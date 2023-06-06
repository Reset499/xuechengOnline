package com.xuecheng.content.po;

import lombok.Data;

@Data
public class CourseCategory {

  private String id;
  private String name;
  private String label;
  private String parentid;
  private long isShow;
  private long orderby;
  private long isLeaf;

}
