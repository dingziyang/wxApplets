package com.dcm.wxapplets.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: Swagger2Config
 * @Description: swagger2配置(可以按照包路径或者URL路径分组，这里选择按照包路径分组)
 * @Auther: dcm
 * @Date: 2018-5-31 12:30
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Autowired
    private TypeResolver typeResolver;

    /**
      * @author dcm
      * @date 2018-7-17 15:37
      * @Description: 自定义的公共方法
      * @param: title 标题
      * @param: description 说明
      * @param: teamService 团队支持信息
      * @param: version 版本
      * @throws
      */
    private ApiInfo setApiInfo(String title, String description, String teamService, String version) {
        return new ApiInfoBuilder().title(title).description(description).termsOfServiceUrl(teamService).version(version).build();
    }

    @Bean
    public Docket wxRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(setApiInfo("商办通-微信-api文档","商办通-微信-api文档",
                        "https://blog.csdn.net/xu_san_duo", "1.0"))
                .groupName("1.微信小程序接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dcm.wxapplets.controller.wx"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket pcRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(setApiInfo("商办通-PC端-api文档","商办通-PC端-api文档",
                        "https://blog.csdn.net/xu_san_duo", "1.0"))
                .groupName("2.PC端接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dcm.wxapplets.controller.pc"))
                .paths(PathSelectors.any())
                .build();
    }


}
