package javaone.seamforge.demo.domain;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javaone.seamforge.demo.domain.Rating;
import javaone.seamforge.demo.domain.Talk;
import javax.persistence.ManyToOne;
@Entity public class Feedback implements java.io.Serializable {
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
  @Column private String author;
  public String getAuthor(){
    return this.author;
  }
  public void setAuthor(  final String author){
    this.author=author;
  }
  @Column private Rating content;
  public Rating getContent(){
    return this.content;
  }
  public void setContent(  final Rating content){
    this.content=content;
  }
  @Column private Rating skills;
  public Rating getSkills(){
    return this.skills;
  }
  public void setSkills(  final Rating skills){
    this.skills=skills;
  }
  @Column private Rating demos;
  public Rating getDemos(){
    return this.demos;
  }
  public void setDemos(  final Rating demos){
    this.demos=demos;
  }
  @Column private Rating explanation;
  public Rating getExplanation(){
    return this.explanation;
  }
  public void setExplanation(  final Rating explanation){
    this.explanation=explanation;
  }
  @Column private Rating depth;
  public Rating getDepth(){
    return this.depth;
  }
  public void setDepth(  final Rating depth){
    this.depth=depth;
  }
  @Column private Rating overall;
  public Rating getOverall(){
    return this.overall;
  }
  public void setOverall(  final Rating overall){
    this.overall=overall;
  }
  @Column private String comments;
  public String getComments(){
    return this.comments;
  }
  public void setComments(  final String comments){
    this.comments=comments;
  }
  @ManyToOne private Talk talk=new Talk();
  public Talk getTalk(){
    return this.talk;
  }
  public void setTalk(  final Talk talk){
    this.talk=talk;
  }
}
