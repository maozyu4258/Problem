package com.ps.domain.core;


import java.io.Serializable;

public class QasysIntegralT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private long mid;
  private long integral;
  private java.sql.Timestamp time;
  private String state;


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


  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
