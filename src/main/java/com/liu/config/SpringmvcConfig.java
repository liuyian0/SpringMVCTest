package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Springmvc配置类，本质上还是一个spring配置类
@Configuration
@ComponentScan("com.liu.controller")//指定要扫描的包
public class SpringmvcConfig {
}
