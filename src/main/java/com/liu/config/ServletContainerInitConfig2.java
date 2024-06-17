package com.liu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web容器配置类
public class ServletContainerInitConfig2 extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //加载SpringMVC配置
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringmvcConfig.class};
    }

    //设置由SpringMVC控制器处理的请求映射路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};//SpringMVC控制器处理所有的请求
    }
}
