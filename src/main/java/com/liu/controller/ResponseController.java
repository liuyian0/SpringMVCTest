package com.liu.controller;

import com.liu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResponseController {
    //响应文本数据
    @RequestMapping("/toText")
    @ResponseBody
    public String toText(){
        System.out.println("返回文本数据");
        return "toText";
    }
    //响应POJO对象
    @RequestMapping("toJsonPojo")
    @ResponseBody
    public User toJsonPojo(){
        System.out.println("返回json对象数据");
        User user = new User("zhangsan",18);
        return user;//返回值是对象类型（把对象转换为json格式字符串）
        /**
         * {
         *     "name": "zhangsan",
         *     "age": 18,
         *     "address": null
         * }
         */
    }
    //响应POJO集合对象
    @RequestMapping("/toJsonList")
    @ResponseBody
    public List<User> toJsonList(){
        System.out.println("返回json集合数据");
        User user1 = new User("张三",18);
        User user2 = new User("赵四",19);
        ArrayList<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
        /**
         * 返回到postman端
         * [
         *     {
         *         "name": "张三",
         *         "age": 18,
         *         "address": null
         *     },
         *     {
         *         "name": "赵四",
         *         "age": 19,
         *         "address": null
         *     }
         * ]
         */
    }
    //响应页面/跳转页面
    @RequestMapping("/toJumpPage")
    @ResponseBody
    public String toJumpPage(){
        System.out.println("跳转页面");
        return "index.jsp";
    }
}
