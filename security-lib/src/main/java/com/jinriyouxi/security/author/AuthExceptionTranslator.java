package com.jinriyouxi.security.author;

import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultJson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;


public class AuthExceptionTranslator implements WebResponseExceptionTranslator {

  @Override
  public ResponseEntity translate(Exception e) throws Exception {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Cache-Control", "no-store");
    headers.set("Pragma", "no-cache");
    ResultJson resultJson = new ResultJson();
    resultJson.setCode(ResultCode.FAILURE);
    resultJson.setMsg(e.getMessage());
    return new ResponseEntity(resultJson, headers, HttpStatus.FORBIDDEN);
  }
}
