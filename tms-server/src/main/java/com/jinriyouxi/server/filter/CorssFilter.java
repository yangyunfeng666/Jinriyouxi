package com.jinriyouxi.server.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 跨域处理
 */
@Component
@Configuration
public class CorssFilter implements Filter {
 
  @Override
  public void doFilter(
      ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse httpServletResponse = (HttpServletResponse) res;
    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    httpServletResponse.setHeader("Access-control-Allow-Credentials", "true"); //
    httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin")); //标识允许哪个域到请求，直接修改成请求头的域
    httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");//标识允许的请求方法
    // 响应首部 Access-Control-Allow-Headers 用于 preflight request （预检请求）中，列出了将会在正式请求的 Access-Control-Expose-Headers 字段中出现的首部信息。修改为请求首部
    httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
    httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
    //给option请求直接返回正常状态
    if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
      httpServletResponse.setStatus(HttpStatus.OK.value());
    }
    chain.doFilter(req, res);
  }
 
  @Override
  public void init(FilterConfig filterConfig) {}
 
  @Override
  public void destroy() {}
 
}