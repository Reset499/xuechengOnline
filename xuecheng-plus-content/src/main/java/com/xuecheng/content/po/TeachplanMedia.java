package com.xuecheng.content.po;

import lombok.Data;

@Data
public class TeachplanMedia {

  private long id;
  private String mediaId;
  private long teachplanId;
  private long courseId;
  private String mediaFileName;
  private java.sql.Timestamp createDate;
  private String createPeople;
  private String changePeople;


}
