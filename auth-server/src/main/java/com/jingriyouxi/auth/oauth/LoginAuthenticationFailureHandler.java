package com.jingriyouxi.auth.oauth;

import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultJson;
import com.jinriyouxi.common.constant.ResultMsg;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("loginAuthenticationFailureHandler")
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
      HttpServletResponse response, AuthenticationException e)
      throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    ResultJson resultJson = new ResultJson(ResultCode.FAILURE, ResultMsg.INVALID_LOGIN);
    response.setStatus(HttpStatus.SC_OK);
    PrintWriter printWriter = null;
    printWriter = response.getWriter();
    printWriter.append(resultJson.toString());
  }
}
