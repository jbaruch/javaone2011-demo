package javaone.seamforge.demo.view;
import java.util.List;
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.javaone.rad.tools.demo.entities.Speaker;
import org.jboss.forge.persistence.PersistenceUtil;
import org.jboss.forge.persistence.PaginationHelper;
import org.jboss.seam.transaction.Transactional;
@Transactional @Named @Stateful @RequestScoped public class SpeakerBean extends PersistenceUtil {
  private List<Speaker> list=null;
  private Speaker speaker=new Speaker();
  private long id=0;
  private PaginationHelper<Speaker> pagination;
  public void load(){
    speaker=findById(Speaker.class,id);
  }
  public String create(){
    create(speaker);
    return "view?faces-redirect=true&id=" + speaker.getId();
  }
  public String delete(){
    delete(speaker);
    return "list?faces-redirect=true";
  }
  public String save(){
    save(speaker);
    return "view?faces-redirect=true&id=" + speaker.getId();
  }
  public long getId(){
    return id;
  }
  public void setId(  long id){
    this.id=id;
    if (id > 0) {
      load();
    }
  }
  public Speaker getSpeaker(){
    return speaker;
  }
  public void setSpeaker(  Speaker speaker){
    this.speaker=speaker;
  }
  public List<Speaker> getList(){
    if (list == null) {
      list=getPagination().createPageDataModel();
    }
    return list;
  }
  public void setList(  List<Speaker> list){
    this.list=list;
  }
  public PaginationHelper<Speaker> getPagination(){
    if (pagination == null) {
      pagination=new PaginationHelper<Speaker>(10){
        @Override public int getItemsCount(){
          return count(Speaker.class);
        }
        @Override public List<Speaker> createPageDataModel(){
          return new ArrayList<Speaker>(findAll(Speaker.class,getPageFirstItem(),getPageSize()));
        }
      }
;
    }
    return pagination;
  }
  private void recreateModel(){
    list=null;
  }
  public String next(){
    getPagination().nextPage();
    recreateModel();
    return "list";
  }
  public String previous(){
    getPagination().previousPage();
    recreateModel();
    return "list";
  }
}
