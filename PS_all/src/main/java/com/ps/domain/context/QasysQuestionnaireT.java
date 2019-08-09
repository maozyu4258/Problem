package com.ps.domain.context;


public class QasysQuestionnaireT {

  private long id;
  private String projectName;
  private long integral;
  private java.sql.Timestamp time;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
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

}
