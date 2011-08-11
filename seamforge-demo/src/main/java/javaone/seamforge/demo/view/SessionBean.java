package javaone.seamforge.demo.view;

import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.javaone.rad.tools.demo.entities.Session;
import org.jboss.forge.persistence.PersistenceUtil;
import org.jboss.forge.persistence.PaginationHelper;
import org.jboss.seam.transaction.Transactional;

@Transactional
@Named
@Stateful
@RequestScoped
public class SessionBean extends PersistenceUtil {
    private List<Session> list = null;
    private Session session = new Session();
    private long id = 0;
    private PaginationHelper<Session> pagination;

    public void load() {
        session = findById(Session.class, id);
    }

    public String create() {
        create(session);
        return "view?faces-redirect=true&id=" + session.getId();
    }

    public String delete() {
        delete(session);
        return "list?faces-redirect=true";
    }

    public String save() {
        save(session);
        return "view?faces-redirect=true&id=" + session.getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        if (id > 0) {
            load();
        }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public List<Session> getList() {
        if (list == null) {
            list = getPagination().createPageDataModel();
        }
        return list;
    }

    public void setList(List<Session> list) {
        this.list = list;
    }

    public PaginationHelper<Session> getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper<Session>(10) {
                @Override
                public int getItemsCount() {
                    return count(Session.class);
                }

                @Override
                public List<Session> createPageDataModel() {
                    return new ArrayList<Session>(findAll(Session.class, getPageFirstItem(), getPageSize()));
                }
            }
            ;
        }
        return pagination;
    }

    private void recreateModel() {
        list = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "list";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "list";
    }
}
