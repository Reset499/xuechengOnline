package com.xuecheng.entity;

import lombok.Data;

@Data
public class MqMessageHistory {

  private long id;
  private String messageType;
  private String businessKey1;
  private String businessKey2;
  private String businessKey3;
  private long executeNum;
  private long state;
  private java.sql.Timestamp returnfailureDate;
  private java.sql.Timestamp returnsuccessDate;
  private String returnfailureMsg;
  private java.sql.Timestamp executeDate;
  private String stageState1;
  private String stageState2;
  private String stageState3;
  private String stageState4;

}
