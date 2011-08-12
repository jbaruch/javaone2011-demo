package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Dror Bereznitsky
 * Date: 8/12/11
 * Time: 5:29 PM
 *
 * @author Dror Bereznitsky
 */
@Entity
public class Speaker extends Model {
    public String firstName;
    public String lastName;
    public String email;

    @OneToMany(mappedBy = "speaker")
    public List<Talk> talks;

    public Speaker(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.talks = new ArrayList<Talk>();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
