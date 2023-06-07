package com.xuecheng.system.pojo;

import lombok.Data;

@Data
public class Dictionary {

  private long id;
  private String name;
  private String code;
  private String itemValues;

  public Dictionary(long id, String name, String code, String itemValues) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.itemValues = itemValues;
  }

  public Dictionary() {
  }
}
