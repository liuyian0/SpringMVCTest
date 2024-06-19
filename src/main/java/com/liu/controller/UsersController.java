package com.liu.controller;

import com.liu.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class UsersController {
    //普通参数：请求参数与形参名称对应即可完成参数传递
    @RequestMapping("commonParam")
    @ResponseBody
    public String commonParam(@RequestParam("userName") String name,
                              @RequestParam("userAge") int age){
        System.out.println("普通参数传递：name="+name);
        System.out.println("普通参数传递：age="+age);
        return "commonParam";
        //例如：postman输入http://localhost:8080/commonParam?name=zhangsan&age=18
    }
    //pojo参数：请求参数与形参对象中的属性对应即可完成参数传递
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("pojo参数传递：user="+user);
        return "pojoParam";
        //例如：postman输入http://localhost:8080/pojoParam?name=zhangsan&age=18
    }
    //嵌套pojo参数：嵌套属性按照层次结构设定名称即可完成参数传递
    @RequestMapping("/pojoContainPojoParam")
    @ResponseBody
    public String pojoContainPojoParam(User user){
        System.out.println("pojo嵌套pojo参数传递：user="+user);
        return "pojoContainPojoParam";
        //例如：postman输入http://localhost:8080/pojoContainPojoParam?name=zhangsan&age=18&address.province=henan&address.city=zhengzhou
    }
    //数组参数：同名请求参数可以直接映射到对应名称的形参数组对象中
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递：likes="+likes);
        return "arrayParam";
        //例如：postman输入http://localhost:8080/arrayParam?likes=sing&likes=jump&likes=rap&likes=basketball
    }
    //集合参数：同名请求参数可以使用@RequestParam注解映射到对应名称的集合对象中作为数据
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递：likes="+likes);
        return "listParam";
        //例如：postman输入http://localhost:8080/listParam?likes=sing&likes=jump&likes=rap&likes=basketball
    }
    //日期参数
    @RequestMapping("/dateParam")
    @ResponseBody
    public String dateParam(Date date1,//默认格式yyyy/MM/dd
                            @DateTimeFormat(pattern = "yyyy-MM-dd")Date date2,
                            @DateTimeFormat(pattern = "dd/MM/yyyy")Date date3){
        System.out.println("日期参数传递：默认"+date1);//日期参数传递：默认Thu Jun 19 00:00:00 CST 2014
        System.out.println("日期参数传递yyyy-MM-dd"+date2);//日期参数传递yyyy-MM-ddThu Jun 19 00:00:00 CST 2014
        System.out.println("日期参数传递dd/Mm/yyyy"+date3);//日期参数传递dd/Mm/yyyyThu Jun 19 00:00:00 CST 2014
        //返回的都是Thu Jun 19 00:00:00 CST 2014
        return "dateParam";
    }
    /**
    普通参数传递：name=zhangsan
    普通参数传递：age=18
    pojo参数传递：user=User{name='zhangsan', age=18, address=null}
    pojo嵌套pojo参数传递：user=User{name='zhangsan', age=18, address=Address{province='henan', city='zhengzhou'}}
    数组参数传递：likes=[sing, jump, rap, basketball]
    集合参数传递：likes=[sing, jump, rap, basketball]
    postman端接收相应的return
     */
}
