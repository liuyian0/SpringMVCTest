package com.liu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration//spring配置类
@ComponentScan("com.liu.service")//扫描指定包下的类，并添加到ioc容器
@PropertySource("classpath:db.properties")//加载外部配置文件
@Import(value={JdbcConfig.class,MybatisConfig.class})//引入配置类
@EnableTransactionManagement//开启事务管理支持
public class SpringConfig {
}
