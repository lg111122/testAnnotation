package com.test.springmvc.annotation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesetController {
    @RequestMapping("/test")
    public String test(){
        return "test springmvc annotation config start........";
    }
}
