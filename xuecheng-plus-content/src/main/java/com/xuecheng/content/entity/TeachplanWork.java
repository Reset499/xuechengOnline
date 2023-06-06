package com.xuecheng.content.entity;

import lombok.Data;

@Data
public class TeachplanWork {

  private long id;
  private long workId;
  private String workTitle;
  private long teachplanId;
  private long courseId;
  private java.sql.Timestamp createDate;
  private long coursePubId;


}
