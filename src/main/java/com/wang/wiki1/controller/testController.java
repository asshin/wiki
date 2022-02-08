package com.wang.wiki1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @create 2022-02-08 11:50
 */
@RestController

public class testController {
    @Value("${test.name:wang}")
    private String  name;
    @RequestMapping("/hello")
    public  String hello(){

        return  "hello1,"+name;
    }
    @RequestMapping("/hello/post")
    public  String helloPost(String name){

        return  "hello,"+name;
    }
}
