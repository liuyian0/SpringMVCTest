package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//定义表现层控制器bean
@Controller//指定UserController类为表现层的控制器bean
public class UserController {
    @RequestMapping("/save")//让请求的路径/save映射到目标方法上
    @ResponseBody//设置当前操作返回结果为字符串
    public String save(){
        System.out.println("保存用户...");
        return "success";
    }
}
