package com.ganzib.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/index")
    public String test(){
        return "index";
    }
    @GetMapping("/test")
    public String test2(){
        return "test";
    }

    @RequiresPermissions("admin:test")
    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }

    //错误页面展示
    @GetMapping("/error")
    public String error(){
        return "error ok!";
    }




}
