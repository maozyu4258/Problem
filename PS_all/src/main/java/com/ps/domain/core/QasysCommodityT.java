package com.ps.domain.core;


import java.io.Serializable;

public class QasysCommodityT implements Serializable {
  private static final long serialVersionUID = -1L;
  private long id;
  private String name;
  private long exchangeIntegral;
  private String value;
  private String describe;
  private java.sql.Date startTime;
  private java.sql.Date endTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getExchangeIntegral() {
    return exchangeIntegral;
  }

  public void setExchangeIntegral(long exchangeIntegral) {
    this.exchangeIntegral = exchangeIntegral;
  }


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  public String getDescribe() {
    return describe;
  }

  public void setDescribe(String describe) {
    this.describe = describe;
  }


  public java.sql.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Date startTime) {
    this.startTime = startTime;
  }


  public java.sql.Date getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Date endTime) {
    this.endTime = endTime;
  }

}
