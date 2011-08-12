package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * User: Dror Bereznitsky
 * Date: 8/12/11
 * Time: 5:33 PM
 *
 * @author Dror Bereznitsky
 */
@Entity
public class Feedback extends Model {
    public String author;
    public Rating content;
    public Rating skills;
    public Rating  demos;
    public Rating explanation;
    public Rating depth;
    public Rating overall;
    public String comments;

    @ManyToOne
    public Talk talk;

    public Feedback(String author, Rating content, Rating skills, Rating demos, Rating explanation, Rating depth, Rating overall, String comments, Talk talk) {
        this.author = author;
        this.content = content;
        this.skills = skills;
        this.demos = demos;
        this.explanation = explanation;
        this.depth = depth;
        this.overall = overall;
        this.comments = comments;
        this.talk = talk;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "author='" + author + '\'' +
                ", content=" + content +
                ", skills=" + skills +
                ", demos=" + demos +
                ", explanation=" + explanation +
                ", depth=" + depth +
                ", overall=" + overall +
                ", comments=" + comments +
                '}';
    }
}
