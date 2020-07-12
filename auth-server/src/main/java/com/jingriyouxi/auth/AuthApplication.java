package com.jingriyouxi.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@MapperScan(basePackages = {"com.jingriyouxi.auth.mapper","com.jinriyouxi.security.mapper"})
@SpringBootApplication(scanBasePackages = {"com.jinriyouxi.security","com.jingriyouxi.auth"})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
