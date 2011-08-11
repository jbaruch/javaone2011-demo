package com.javaone.rad.tools.demo.entities;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import com.javaone.rad.tools.demo.entities.Speaker;
import javax.persistence.ManyToOne;
@Entity public class Session implements java.io.Serializable {
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
  @Column private String title;
  public String getTitle(){
    return this.title;
  }
  public void setTitle(  final String title){
    this.title=title;
  }
  @Column private int code;
  public int getCode(){
    return this.code;
  }
  public void setCode(  final int code){
    this.code=code;
  }
  @ManyToOne private Speaker speaker=new Speaker();
  public Speaker getSpeaker(){
    return this.speaker;
  }
  public void setSpeaker(  final Speaker speaker){
    this.speaker=speaker;
  }
}
