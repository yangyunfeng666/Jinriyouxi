package com.jinriyouxi.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.jinriyouxi.server.mapper","com.jinriyouxi.security.mapper"})
@SpringBootApplication(scanBasePackages = {"com.jinriyouxi.security","com.jinriyouxi.server"})
public class TmsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmsServerApplication.class, args);
    }

}
