package com.xuecheng.content.po;

import lombok.Data;

@Data
public class Teachplan {

  private Long id;
  private String pname;
  private Long parentid;
  private Long grade;
  private String mediaType;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String description;
  private String timelength;
  private Integer orderby;
  private Long courseId;
  private Long coursePubId;
  private Integer status;
  private String isPreview;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp changeDate;


}
