package javaone.seamforge.demo.domain;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Set;
import java.util.HashSet;
import javaone.seamforge.demo.domain.Talk;
import javax.persistence.OneToMany;
@Entity public class Speaker implements java.io.Serializable {
  @Id private @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="id",updatable=false,nullable=false) Long id=null;
  @Version private @Column(name="version") int version=0;
  public Long getId(){
    return this.id;
  }
  public void setId(  final Long id){
    this.id=id;
  }
  public int getVersion(){
    return this.version;
  }
  public void setVersion(  final int version){
    this.version=version;
  }
  @Column private String firstName;
  public String getFirstName(){
    return this.firstName;
  }
  public void setFirstName(  final String firstName){
    this.firstName=firstName;
  }
  @Column private String lastName;
  public String getLastName(){
    return this.lastName;
  }
  public void setLastName(  final String lastName){
    this.lastName=lastName;
  }
  @Column private String email;
  public String getEmail(){
    return this.email;
  }
  public void setEmail(  final String email){
    this.email=email;
  }
  private @OneToMany(mappedBy="speaker") Set<Talk> talks=new HashSet<Talk>();
  public Set<Talk> getTalks(){
    return this.talks;
  }
  public void setTalks(  final Set<Talk> talks){
    this.talks=talks;
  }
}
