package com.liu.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


//web容器配置类
public class ServletInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    //指定spring配置类加载（根配置）
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    //指定springmvc配置类加载
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringmvcConfig.class};
    }

    @Override
    //配置springmvc拦截路径为/（全路径）
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    //中文乱码过滤器
    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("utf-8");
        return new Filter[]{encodingFilter};
    }
}
