package com.wang.wiki1.controller;

import com.wang.wiki1.domain.Test;
import com.wang.wiki1.service.TestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zsw
 * @create 2022-02-08 11:50
 */
@RestController

public class testController {
    @Value("${test.name:wang}")
    private String  name;
    @Autowired
    private TestServer testServer;
    @RequestMapping("/hello")
    public  String hello(){

        return  "hello1,"+name;
    }
    @RequestMapping("/hello/post")
    public  String helloPost(String name){

        return  "hello,"+name;
    }
    @RequestMapping("/hello/test")
    public  String helloTest(){
        List<Test> list=testServer.list();
        return  "hello,"+list;
    }
}
