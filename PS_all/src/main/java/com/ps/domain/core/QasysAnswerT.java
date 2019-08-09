package com.ps.domain.core;


import java.io.Serializable;

public class QasysAnswerT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private long mid;
  private long qid;
  private String answer;
  private java.sql.Timestamp time;
  private String type;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMid() {
    return mid;
  }

  public void setMid(long mid) {
    this.mid = mid;
  }


  public long getQid() {
    return qid;
  }

  public void setQid(long qid) {
    this.qid = qid;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
