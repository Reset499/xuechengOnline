package com.xuecheng.content.entity;

import lombok.Data;

@Data
public class CoursePublish {

  private long id;
  private long companyId;
  private String companyName;
  private String name;
  private String users;
  private String tags;
  private String username;
  private String mt;
  private String mtName;
  private String st;
  private String stName;
  private String grade;
  private String teachmode;
  private String pic;
  private String description;
  private String market;
  private String teachplan;
  private String teachers;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp onlineDate;
  private java.sql.Timestamp offlineDate;
  private String status;
  private String remark;
  private String charge;
  private double price;
  private double originalPrice;
  private long validDays;




}
