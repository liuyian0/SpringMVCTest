package com.liu.controller;

import com.liu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class User2Controller {
    //使用@RequestBody注解将外部传递的json数据映射到形参的实体类对象中，要求属性名称一一对应
    //pojo参数：json格式
    @RequestMapping("/pojoParamForJson")
    @ResponseBody
    public String pojoParamForJson(@RequestBody User user){
        System.out.println("pojo(json)参数传递：user="+user);
        return "pojoParamForJson";
        /**
         * 例如：postman输入http://localhost:8080/pojoParamForJson
         * 选中Body->raw json
         * 空白部分输入json格式的pojo
         * {
         *     "name":"zhangsan",
         *     "age":18
         * }
         * send+
         */
    }
    //集合参数：json格式
    @RequestMapping("/listParamForJson")
    @ResponseBody
    public String listParamForJson(@RequestBody List<String> likes){
        System.out.println("list(json)参数传递：likes"+likes);
        return "listParamForJson";
        /**
         * postman空白处输入json格式的集合
         * [
         *     "sing","jump","rap","basketball"
         * ]
         */
    }
    //集合pojo：json格式
    @RequestMapping("/listPojoParamForJson")
    @ResponseBody
    public String listPojoParamForJson(@RequestBody List<User> list){
        System.out.println("list pojo(json)参数传递：list="+list);
        return "listPojoParamForJson";
        /**
         * postman的空白处输入json格式的list pojo
         * [
         *     {"name":"zhangsan","age":18},
         *     {"name":"zhaosi","age":19}
         * ]
         */
    }

    /**
     * pojo(json)参数传递：user=User{name='zhangsan', age=18, address=null}
     * list(json)参数传递：likes=[sing, jump, rap, basketball]
     * list pojo(json)参数传递：list=[User{name='zhangsan', age=18, address=null}, User{name='zhaosi', age=19, address=null}]
     */
}
