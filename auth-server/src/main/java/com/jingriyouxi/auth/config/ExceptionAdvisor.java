package com.jingriyouxi.auth.config;


import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultJson;
import com.jinriyouxi.common.exception.ResponseException;
import javax.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionAdvisor {

  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  ResponseEntity illArgrementException(IllegalArgumentException e) {
    return ResponseEntity.ok(e.getMessage());
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(ResponseException.class)
  @ResponseBody
  public ResultJson handlerException(ResponseException e) {
    ResultJson resultJson = new ResultJson<>();
    resultJson.setCode(ResultCode.FAILURE);
    resultJson.setMsg(e.getMessage());
    return resultJson;
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public ResultJson handlerException(MethodArgumentNotValidException e) {
    ResultJson resultJson = new ResultJson<>();
    resultJson.setCode(ResultCode.FAILURE);
    resultJson.setMsg(e.getMessage());
    return resultJson;
  }

  @ResponseStatus(HttpStatus.OK)
  @ExceptionHandler(UnexpectedTypeException.class)
  @ResponseBody
  public ResultJson handlerException(UnexpectedTypeException e) {
    ResultJson resultJson = new ResultJson<>();
    resultJson.setCode(ResultCode.FAILURE);
    resultJson.setMsg(e.getMessage());
    return resultJson;
  }



}
