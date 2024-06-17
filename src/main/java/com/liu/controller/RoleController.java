package com.liu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public String save(){
        System.out.println("RoleController.save");
        return "save success";
    }
    @RequestMapping(path = "delete",method = RequestMethod.POST)
    @ResponseBody
    public String delete(){
        System.out.println("RoleController.delete");
        return "delete success";
    }
}
