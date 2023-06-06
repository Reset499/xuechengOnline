package com.xuecheng.content.po;

import lombok.Data;

@Data
public class CourseAudit {

  private long id;
  private long courseId;
  private String auditMind;
  private String auditStatus;
  private String auditPeople;
  private java.sql.Timestamp auditDate;


}
