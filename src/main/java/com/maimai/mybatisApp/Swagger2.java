package com.maimai.mybatisApp;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * Created by maimai on 2018-02-08.
 */
@SuppressWarnings("AliDeprecation")
@Configuration
public class Swagger2 {
    @Bean
    public Docket createRestApi() {


        //我针对RestController注解的类和ResponseBody注解的方法才生成Swaager的API，并且排除了特定的类
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class)// 排除
                {
                    return false;
                }
                if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                {
                    return true;
                }
                if (input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                {
                    return true;
                }
                return false;
            }
        };

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.maimai.mybatisApp.controller"))
//                .paths(PathSelectors.any())
//                .paths(or(regex("/api/.*")))//过滤接口//只要api下面的接口
                .paths(doFilteringRules())
                .build();
    }

    /**
     * 设置过滤规则
     * 这里的过滤规则支持正则匹配
     *
     * @return
     */
    private Predicate<String> doFilteringRules() {
        return or(
                regex("/api.*"),
                regex("/vehicles.*")
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("简单优雅的restfun风格，https://baicaocanhua.github.io/")
                .termsOfServiceUrl("NO terms of service")
                .contact(new Contact("麦麦", "https://baicaocanhua.github.io/", "330557864@qq.com"))//作者
                .version("1.0")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

//    http://127.0.0.1:8080/swagger-ui.html
}
