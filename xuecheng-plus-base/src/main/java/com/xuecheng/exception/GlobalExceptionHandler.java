package com.xuecheng.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mr.M
 * @version 1.0
 * @description TODO
 * @date 2023/2/12 17:01
 */
@Slf4j
@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

 //对项目的自定义异常类型进行处理
   @ResponseBody
   @ExceptionHandler(XueChengPlusException.class)//出现了这个异常 当前这个歌处理器就会处理异常 返回json数据
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 public RestErrorResponse customException(XueChengPlusException e){

    //记录异常
    log.error("系统异常{}",e.getErrMessage(),e);
    //.. 这里可以补充异常的处理 比如重连或者什么的

    //解析出异常信息
    String errMessage = e.getErrMessage();
    RestErrorResponse restErrorResponse = new RestErrorResponse(errMessage);
    return restErrorResponse;
   }


   @ResponseBody
   @ExceptionHandler(Exception.class)//若不是自定义异常 针对其他异常 则由这个方法捕获
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 public RestErrorResponse exception(Exception e){

    //记录异常
    log.error("系统异常{}",e.getMessage(),e);

    //解析出异常信息
    RestErrorResponse restErrorResponse = new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());
    return restErrorResponse;
   }


}
