package com.yxy.market1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源路径
        registry.addResourceHandler("/**").addResourceLocations("classpath:static/");
        registry.addResourceHandler("/storage/**").addResourceLocations("file:/home/yxy/project_upload/");
    }
}
