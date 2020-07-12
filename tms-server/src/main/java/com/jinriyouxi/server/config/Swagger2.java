package com.jinriyouxi.server.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 implements WebMvcConfigurer {


    @Value("${auth_server}")
    private String auth_server;

    @Value("${swagger.enable}")
    private boolean swaggerEnable;

    @Bean
    public Docket createSwaggerApi() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
            .name("Authorization")
            .description("认证token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build());
        List arrayList = new ArrayList();
        arrayList.add(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("Error"))
                .build());
        arrayList.add(
                new ResponseMessageBuilder()
                        .code(403)
                        .message("Forbidden!")
                        .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .globalOperationParameters(parameters)
                .enable(swaggerEnable)
//                .globalResponseMessage(RequestMethod.GET, arrayList) //设置返回码错误
                .apiInfo(api())
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fbpay.controller"))
                .paths(PathSelectors.any()) //仅包含特点控制器的
                .build();

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    /**
     * 这个类决定了你使用哪种认证方式，我这里使用密码模式
     * 其他方式自己摸索一下，完全莫问题啊
     */
    private SecurityScheme securityScheme() {
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(auth_server + "/author/login");
        return new OAuthBuilder()
            .name("spring_oauth")
            .grantTypes(Collections.singletonList(grantType))
            .scopes(Arrays.asList(scopes()))
            .build();
    }

    /**
     * 这里设置 swagger2 认证的安全上下文
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(Collections.singletonList(new SecurityReference("spring_oauth", scopes())))
            .forPaths(PathSelectors.any())
            .build();
    }

    /**
     * 这里是写允许认证的scope
     */
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
            new AuthorizationScope("all", "All scope is trusted!")
        };
    }

    private ApiInfo api() {
        return new ApiInfoBuilder()
                .title("认证服务的API")
                .description("")
                .contact("xxxx")
                .version("1.0.0")
                .build();
    }
}
