package com.ps.domain.core;


import java.io.Serializable;

public class QasysMemberT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private String username;
  private String password;
  private long integral;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public QasysMemberT(){

  }

  public QasysMemberT(long id, String username, String password, long integral) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.integral = integral;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }
}
