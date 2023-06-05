package com.xuecheng.entity;

import lombok.Data;

@Data
public class CourseBase {

  private long id;
  private long companyId;
  private String companyName;
  private String name;
  private String users;
  private String tags;
  private String mt;
  private String st;
  private String grade;
  private String teachmode;
  private String description;
  private String pic;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp changeDate;
  private String createPeople;
  private String changePeople;
  private String auditStatus;
  private String status;

}
