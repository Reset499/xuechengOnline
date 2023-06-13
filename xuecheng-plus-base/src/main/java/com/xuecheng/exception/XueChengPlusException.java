package com.xuecheng.exception;

/**
 * @author Mr.M
 * @version 1.0
 * @description 本项目自定义异常类型
 * @date 2023/2/12 16:56
 */

//自定义异常类型 继承RuntimeException
public class XueChengPlusException extends RuntimeException {

    private String errMessage;

    public XueChengPlusException() {
    }

    public XueChengPlusException(String message) {
        super(message);
        this.errMessage = message;

    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    //抛出异常(自定义但并不是通用异常)
    public static void cast(String message){
        throw new XueChengPlusException(message);
    }
    //抛出异常(自定义且为通用异常)
    public static void cast(CommonError error){
        throw new XueChengPlusException(error.getErrMessage());
    }

}
