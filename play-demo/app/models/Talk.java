package models;

import play.db.jpa.Model;
import play.modules.search.Field;
import play.modules.search.Indexed;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dror Bereznitsky
 * Date: 8/12/11
 * Time: 5:27 PM
 *
 * @author Dror Bereznitsky
 */
@Indexed
@Entity
public class Talk extends Model {
    public Long code;
    @Field
    public String title;
    public String track;
    public String category;

    @ManyToOne
    public Speaker speaker;

    @OneToMany(mappedBy = "talk")
    public List<Feedback> feedback;

    public Talk(Long code, String title, String track, String category, Speaker speaker) {
        this.code = code;
        this.title = title;
        this.track = track;
        this.category = category;
        this.speaker = speaker;
        this.feedback = new ArrayList<Feedback>();
    }

    public Talk addFeedback(Feedback f) {
        feedback.add(f);
        f.talk = this;
        return this;
    }
}
