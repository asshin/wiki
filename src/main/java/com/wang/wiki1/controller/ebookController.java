package com.wang.wiki1.controller;

import com.wang.wiki1.req.EbookReq;
import com.wang.wiki1.req.EbookSaveReq;
import com.wang.wiki1.resp.CommonResp;
import com.wang.wiki1.resp.EbookQueryResp;
import com.wang.wiki1.resp.PageResp;
import com.wang.wiki1.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/resp")
    public CommonResp resp(EbookReq ebookReq){
        CommonResp<PageResp<EbookQueryResp>> listCommonResp = new CommonResp<>();
        PageResp<EbookQueryResp> ebooks = ebookServer.list2(ebookReq);
        listCommonResp.setContent(ebooks);
        return  listCommonResp;
    }
    @RequestMapping("/save")
    public CommonResp save(@RequestBody  EbookSaveReq ebookSaveReq){
        CommonResp listCommonResp = new CommonResp<>();
        ebookServer.save(ebookSaveReq);
        return  listCommonResp;

    }
}
