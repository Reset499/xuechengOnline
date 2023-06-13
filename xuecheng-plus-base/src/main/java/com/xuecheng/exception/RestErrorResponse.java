package com.xuecheng.exception;

import java.io.Serializable;

/**
 * @author Mr.M
 * @version 1.0
 * @description 和前端约定返回的异常信息模型
 * @date 2023/2/12 16:55
 */

//只有一个属性 用于让这个类去返回的json类型
public class RestErrorResponse implements Serializable {

 private String errMessage;

 public RestErrorResponse(String errMessage){
  this.errMessage= errMessage;
 }

 public String getErrMessage() {
  return errMessage;
 }

 public void setErrMessage(String errMessage) {
  this.errMessage = errMessage;
 }
}
