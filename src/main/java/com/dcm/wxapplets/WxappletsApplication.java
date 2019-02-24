package com.dcm.wxapplets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
  * @author xusanduo
  * @date 2019/2/24 14:53
  * @Description: 程序启动类
  * @return
  * @throws
  */
@SpringBootApplication
@ComponentScan("com.dcm.wxapplets.*.**") // 扫描组件，纳入spring容器，这行必须要有
public class WxappletsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WxappletsApplication.class, args);
        System.out.println("--------------WxappletsApplication启动了: http://localhost:9999/swagger-ui.html");
    }

    /**
      * @author xusanduo
      * @date 2019/2/24 14:53
      * @Description: pringBootServletInitializer这个类是springboot提供的web程序初始化的入口，当我们使用外部容器运行项目时
      *  *        会自动加载并且装配。实现了SpringBootServletInitializer的子类需要重写一个configure方法，方法内自动根据
      *  *        WebApplication.class的类型创建一个SpringApplicationBuilder交付给springboot框架来完成初始化运行配置
      * @param: application
      * @return org.springframework.boot.builder.SpringApplicationBuilder
      * @throws
      */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WxappletsApplication.class);
    }


}
