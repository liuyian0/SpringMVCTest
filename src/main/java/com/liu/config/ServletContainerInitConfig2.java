package com.liu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

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

    //POST请求乱码处理
    @Override
    protected Filter[] getServletFilters(){
        //Spring封装的过滤器，拦截所有的请求，如果是POST请求，就将编码修改为指定编码
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
