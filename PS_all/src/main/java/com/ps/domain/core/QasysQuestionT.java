package com.ps.domain.core;


import java.io.Serializable;

public class QasysQuestionT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private long mid;
  private String question;
  private long integral;
  private long aid;
  private java.sql.Timestamp time;


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


  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }


  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }


  public long getAid() {
    return aid;
  }

  public void setAid(long aid) {
    this.aid = aid;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }

}
