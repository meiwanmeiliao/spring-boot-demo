package com.zl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @AUTH zhuolin
 * @DATE 2018/9/12
 * @description:
 **/
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    /**
     *
     * @return
     */
    @Bean
    public Docket accessToken() {
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("api")// 定义组
                .apiInfo(apiInfo())// 配置说明
                .select() // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.zl.controller")) // 拦截的包路径
                .paths(PathSelectors.any())// 拦截的接口路径
                .build(); // 创建
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()//
                .title("测试swagger")// 标题
                .description("swagger")// 描述
                .termsOfServiceUrl("https://github.com/meiwanmeiliao/spring-boot-demo")//
                .contact(new Contact("zhuolin", "https://github.com/meiwanmeiliao/spring-boot-demo", "1228402018@qq.com"))// 联系
                .licenseUrl("https://github.com/meiwanmeiliao/spring-boot-demo")// 地址
                .version("1.0")// 版本
                .build();
    }

}
