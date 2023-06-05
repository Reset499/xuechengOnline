package com.xuecheng.entity;

import lombok.Data;

@Data
public class Teachplan {

  private long id;
  private String pname;
  private long parentid;
  private long grade;
  private String mediaType;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String description;
  private String timelength;
  private long orderby;
  private long courseId;
  private long coursePubId;
  private long status;
  private String isPreview;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp changeDate;


}
