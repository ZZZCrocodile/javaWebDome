package com.example.demoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //可以返回视图
public class HelloController {
    @RequestMapping("/myIndex")
    public String index() {
        System.out.println("hello.springboot的第一个controller");
        return "index";
    }
}
