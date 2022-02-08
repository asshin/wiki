package com.wang.wiki1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @create 2022-02-08 11:50
 */
@RestController
public class testController {
    @RequestMapping("/hello")
    public  String hello(){

        return  "hello";
    }
}
