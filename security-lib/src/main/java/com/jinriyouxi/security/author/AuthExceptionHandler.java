package com.jinriyouxi.security.author;

import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultJson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 用来解决认证过的用户访问需要权限才能访问的资源时的异常
 */
@Slf4j
@Component
public class AuthExceptionHandler extends OAuth2AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException authException) throws IOException {
    log.info("认证失败，禁止访问 {}", request.getRequestURI());
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);
    ResultJson resultJson = new ResultJson(ResultCode.UNAUTHORIZED);
    resultJson.setMsg(ResultCode.UNAUTHORIZED.getMsg());
    PrintWriter printWriter = null;
    printWriter = response.getWriter();
    printWriter.append(resultJson.toString());
  }

}