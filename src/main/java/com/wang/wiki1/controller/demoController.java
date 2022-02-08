package com.wang.wiki1.controller;

import com.wang.wiki1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @create 2022-02-08 16:15
 */
@RestController
@RequestMapping("/demo")
public class demoController {
    @Value("${test.name:wang}")
    private String  name;
    @Autowired
    private DemoService demoServer;
    @RequestMapping("/hello")
    public  String hello(){

        return  "hello2,"+demoServer.list();
    }
    @RequestMapping("/hello/post")
    public  String helloPost(String name){

        return  "hello,"+name;
    }

}
