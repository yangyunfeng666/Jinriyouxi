package com.jinriyouxi.gateway;

import com.jinriyouxi.gateway.filter.TokenFilter;
import com.jinriyouxi.gateway.filter.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    /*
     * @ClassName GatewayServerApplication
     * @Desc TODO   配置限流 Bean
     */
    @Bean(name = "uriKeyResolver")
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    /*
     * @ClassName GatewayServerApplication
     * @Desc TODO   配置认证过滤器 Bean
     */
    @Bean(name = "tokenFilter")
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}
