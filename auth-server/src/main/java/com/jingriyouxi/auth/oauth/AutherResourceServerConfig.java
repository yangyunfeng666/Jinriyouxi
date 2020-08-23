package com.jingriyouxi.auth.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created on 2018/1/17.
 *
 * @author zlf
 * @since 1.0
 */
@Configuration
@EnableResourceServer
public class AutherResourceServerConfig extends ResourceServerConfigurerAdapter {

    /**
     * 自定义登录成功处理器
     */
    @Autowired
    private LoginAuthenticationSuccessHandler loginAuthenticationSuccessHandler;

    @Autowired
    private LoginAuthenticationFailureHandler loginAuthenticationFailureHandler;

    @Autowired
    private LogoutAuthenticationSuccessHander logoutAuthenticationSuccessHander;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().formLogin()
            .loginPage("/author/login") //配置登陆连接
                .failureHandler(loginAuthenticationFailureHandler)
                .successHandler(loginAuthenticationSuccessHandler)//登录成功处理器
                .and().logout().addLogoutHandler(logoutAuthenticationSuccessHander)//退出登录
                .and()
                .authorizeRequests().anyRequest().authenticated().and()
                .csrf().disable();
    }

}
