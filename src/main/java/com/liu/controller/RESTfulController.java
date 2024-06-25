package com.liu.controller;

import com.liu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class RESTfulController {
    //添加用户
    @RequestMapping(value = "/rest",method = RequestMethod.POST)
    @ResponseBody
    public String add(@RequestBody User user){
        System.out.println("add:"+user);
        return "add success";
    }
    //根据id删除用户
    @RequestMapping(value = "/rest/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable Integer id){
        System.out.println("deleteById:"+id);
        return "deleteById success";
    }
    //删除所有用户
    @RequestMapping(value = "/rest",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAll(){
        System.out.println("deleteAll");
        return "delete all success";
    }
    //修改用户
    @RequestMapping(value = "/rest",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println("update:"+user);
        return "update success";
    }
    //根据用户id查询用户
    @RequestMapping(value = "/rest/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable Integer id){
        System.out.println("findById:"+id);
        User user = new User(1, "张三", 18);
        return user;
    }
    //查询所有用户
    @RequestMapping(value = "/rest",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(){
        System.out.println("findAll");
        User user1 = new User(1, "张三", 18);
        User user2 = new User(2, "赵四", 20);
        User user3 = new User(3, "王五", 19);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
    //分页查询数据
    @RequestMapping(value = "/rest/{page}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByPage(@PathVariable Integer page,
                                 @PathVariable Integer pageSize){
        System.out.println("findByPage:有"+page+"页，每页"+pageSize+"条");
        User user1 = new User(1, "张三", 18);
        User user2 = new User(2, "赵四", 20);
        User user3 = new User(3, "王五", 19);
        ArrayList<User> userList = new ArrayList<User>();
        Collections.addAll(userList,user1,user2,user3);
        return userList;

    }
}
