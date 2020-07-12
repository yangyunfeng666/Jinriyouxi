package com.jinriyouxi.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/webjars/**",
            "/v2/api-docs",//swagger api json
            "/swagger-resources/configuration/ui",//用来获取支持的动作
            "/swagger-resources",//用来获取api-docs的URI
            "/swagger-resources/configuration/security",//安全选项
            "/swagger-ui.html").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin();
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/webjars/**","/v2/api-docs",//swagger api json
        "/swagger-resources/configuration/ui",//用来获取支持的动作
        "/swagger-resources",//用来获取api-docs的URI
        "/swagger-resources/configuration/security",//安全选项
        "/swagger-ui.html");
  }
}
