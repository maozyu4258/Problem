package com.ps.domain.core;

import java.io.Serializable;

public class QasysOrderT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private long userId;
  private long comId;
  private java.sql.Timestamp ordertime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getComId() {
    return comId;
  }

  public void setComId(long comId) {
    this.comId = comId;
  }


  public java.sql.Timestamp getOrdertime() {
    return ordertime;
  }

  public void setOrdertime(java.sql.Timestamp ordertime) {
    this.ordertime = ordertime;
  }

}
