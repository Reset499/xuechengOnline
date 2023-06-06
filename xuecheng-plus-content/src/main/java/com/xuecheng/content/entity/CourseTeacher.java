package com.xuecheng.content.entity;

import lombok.Data;

@Data
public class CourseTeacher {

  private long id;
  private long courseId;
  private String teacherName;
  private String position;
  private String introduction;
  private String photograph;
  private java.sql.Timestamp createDate;


}
