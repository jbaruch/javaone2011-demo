package javaone.seamforge.demo.domain;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javaone.seamforge.demo.domain.Speaker;
import javax.persistence.ManyToOne;
import java.util.Set;
import java.util.HashSet;
import javaone.seamforge.demo.domain.Feedback;
import javax.persistence.OneToMany;
@Entity public class Talk implements java.io.Serializable {
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
  @Column private long code;
  public long getCode(){
    return this.code;
  }
  public void setCode(  final long code){
    this.code=code;
  }
  @Column private String title;
  public String getTitle(){
    return this.title;
  }
  public void setTitle(  final String title){
    this.title=title;
  }
  @Column private String track;
  public String getTrack(){
    return this.track;
  }
  public void setTrack(  final String track){
    this.track=track;
  }
  @Column private String category;
  public String getCategory(){
    return this.category;
  }
  public void setCategory(  final String category){
    this.category=category;
  }
  @ManyToOne private Speaker speaker=new Speaker();
  public Speaker getSpeaker(){
    return this.speaker;
  }
  public void setSpeaker(  final Speaker speaker){
    this.speaker=speaker;
  }
  private @OneToMany(mappedBy="talk") Set<Feedback> feedback=new HashSet<Feedback>();
  public Set<Feedback> getFeedback(){
    return this.feedback;
  }
  public void setFeedback(  final Set<Feedback> feedback){
    this.feedback=feedback;
  }
}
