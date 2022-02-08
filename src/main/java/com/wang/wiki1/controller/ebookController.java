package com.wang.wiki1.controller;

import com.wang.wiki1.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @create 2022-02-08 16:33
 */
@RestController
@RequestMapping("/ebook")
public class ebookController {
    @Autowired
    private EbookService ebookServer;
    @RequestMapping("/hello")
    public  String hello(){

        return  "hello2,"+ebookServer.list();
    }
}
