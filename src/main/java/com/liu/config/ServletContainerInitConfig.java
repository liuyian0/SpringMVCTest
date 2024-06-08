package com.liu.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//web容器配置类
//AbstractDispatcherServletInitializer类是SpringMVC提供的快捷初始化Web3.0容器的抽象类
public class ServletContainerInitConfig extends AbstractDispatcherServletInitializer {
    //加载Springmvc配置类，产生springmvc容器(本质还是spring容器)
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        //初始化WebApplicationContext对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //加载指定配置类
        ctx.register(SpringmvcConfig.class);

        return ctx;
    }

    //设置由Springmvc控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //加载spring配置类
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }
}
