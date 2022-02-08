package com.wang.wiki1.controller;

import com.wang.wiki1.domain.Ebook;
import com.wang.wiki1.resp.CommonResp;
import com.wang.wiki1.resp.EbookQueryResp;
import com.wang.wiki1.service.EbookService;
import com.wang.wiki1.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public CommonResp resp(Ebook ebook){
        CommonResp<List<EbookQueryResp>> listCommonResp = new CommonResp<>();
        List<Ebook> ebooks = ebookServer.list2(ebook);
        List<EbookQueryResp> ebookQueryResps = CopyUtil.copyList(ebooks, EbookQueryResp.class);
        listCommonResp.setContent(ebookQueryResps);
        listCommonResp.setMessage("yes");
        return  listCommonResp;
    }
}
