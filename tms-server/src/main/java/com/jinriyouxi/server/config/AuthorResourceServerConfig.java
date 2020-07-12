package com.jinriyouxi.server.config;

import com.jinriyouxi.security.author.AuthExceptionHandler;
import com.jinriyouxi.security.author.JWTAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthorResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Autowired
  private RedisConnectionFactory redisConnectionFactory;
  /**
   * 设置token存储，这一点配置要与授权服务器相一致
   */
  @Bean
  public RedisTokenStore tokenStore(){
    RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
    redisTokenStore.setPrefix("auth-token:");
    return redisTokenStore;
  }

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId("broker_web").stateless(true)
        .tokenStore(tokenStore())
        .accessDeniedHandler(new AuthExceptionHandler()).authenticationEntryPoint(new JWTAuthenticationEntryPoint());
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers(
            "/v2/api-docs",//swagger api json
            "/swagger-resources/configuration/ui",//用来获取支持的动作
            "/swagger-resources",//用来获取api-docs的URI
            "/swagger-resources/configuration/security",//安全选项
            "/swagger-ui.html").permitAll()
            .and().csrf().disable().exceptionHandling().authenticationEntryPoint(new JWTAuthenticationEntryPoint());
  }
}
