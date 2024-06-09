package com.liu.config;

import com.liu.controller.MyServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class MyServletContainerInit implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("start.....");
        MyServlet myServlet = new MyServlet();
        servletContext.addServlet("myServlet",myServlet).addMapping("/myServlet");
    }
}
