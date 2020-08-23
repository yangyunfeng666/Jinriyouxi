package com.jingriyouxi.auth.oauth;

import com.jinriyouxi.common.constant.ResultCode;
import com.jinriyouxi.common.constant.ResultJson;
import com.jinriyouxi.common.constant.ResultMsg;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component("logoutHandler")
public class LogoutAuthenticationSuccessHander implements LogoutHandler {

  @Autowired
  private TokenStore tokenStore;

  @Override
  public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
      Authentication authentication) {
    String accessToken = httpServletRequest.getHeader("Authorization");
    if(StringUtils.isNotBlank(accessToken)){
      accessToken = accessToken.replace("Bearer ","");
      OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(accessToken);
      if(oAuth2AccessToken != null){
        log.info("----access_token是："+oAuth2AccessToken.getValue());
        tokenStore.removeAccessToken(oAuth2AccessToken);
        OAuth2RefreshToken oAuth2RefreshToken = oAuth2AccessToken.getRefreshToken();
        tokenStore.removeRefreshToken(oAuth2RefreshToken);
        tokenStore.removeAccessTokenUsingRefreshToken(oAuth2RefreshToken);
      }
    }
    httpServletResponse.setContentType("application/json;charset=UTF-8");
    ResultJson resultJson = new ResultJson(ResultCode.SUCCESS, ResultMsg.USER_LOGOUT_SUCCESS);
    try {
      httpServletResponse.getWriter().write(resultJson.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  }
