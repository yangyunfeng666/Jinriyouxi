package com.jingriyouxi.auth.oauth;

import com.jinriyouxi.security.author.AuthExceptionHandler;
import com.jinriyouxi.security.author.JWTAuthenticationEntryPoint;
import com.jinriyouxi.security.constants.OriginEndpoints;
import com.jinriyouxi.security.constants.UfaceEndpoints;
import com.jinriyouxi.security.service.CustomerClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("customerClientDetailsService")
    private CustomerClientDetailsService clientDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;


    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        redisTokenStore.setPrefix("auth-token:");
        return  redisTokenStore;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
            .authenticationManager(authenticationManager)
            .tokenStore(tokenStore())
            .userDetailsService(userDetailService);
        mapAuthEndpoints(endpoints);
    }
    /**
     * 自定义访问端点path
     *
     * @param endpoints
     */
    private void mapAuthEndpoints(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.pathMapping(OriginEndpoints.OAUTH_AUTHORIZE_URI, UfaceEndpoints.OAUTH_AUTHORIZE_URI)
            .pathMapping(OriginEndpoints.OAUTH_CHECK_TOKEN, UfaceEndpoints.OAUTH_CHECK_TOKEN)
            .pathMapping(OriginEndpoints.OAUTH_CONFIRM_ACCESS, UfaceEndpoints.OAUTH_CONFIRM_ACCESS)
            .pathMapping(OriginEndpoints.OAUTH_OAUTH_ERROR, UfaceEndpoints.OAUTH_OAUTH_ERROR)
            .pathMapping(OriginEndpoints.OAUTH_TOKEN_KEY, UfaceEndpoints.OAUTH_TOKEN_KEY)
            .pathMapping(OriginEndpoints.OAUTH_TOKEN_URI, UfaceEndpoints.OAUTH_TOKEN_URI);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("isAuthenticated()")
            .accessDeniedHandler(new AuthExceptionHandler()).authenticationEntryPoint(new JWTAuthenticationEntryPoint());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

}
