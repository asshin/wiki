package com.wang.wiki1.controller;
import com.wang.wiki1.req.CategoryQueryReq;
import com.wang.wiki1.req.CategorySaveReq;
import com.wang.wiki1.resp.CommonResp;
import com.wang.wiki1.resp.CategoryQueryResp;
import com.wang.wiki1.resp.PageResp;
import com.wang.wiki1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zsw
 * @create 2022-02-08 16:33
 */
@RestController
@RequestMapping("/category")
public class categoryController {
    @Autowired
    private CategoryService categoryServer;

    @RequestMapping("/hello")
    public  String hello(){

        return  "hello2,"+categoryServer.list();
    }
    @RequestMapping("/resp")
    public CommonResp resp(@Valid CategoryQueryReq categoryReq){
        CommonResp<PageResp<CategoryQueryResp>> listCommonResp = new CommonResp<>();
        PageResp<CategoryQueryResp> categorys = categoryServer.list2(categoryReq);
        listCommonResp.setContent(categorys);
        return  listCommonResp;
    }
    @RequestMapping("/all")
    public CommonResp all(){
        CommonResp<List<CategoryQueryResp>> listCommonResp1 = new CommonResp<>();
        List<CategoryQueryResp> categorys1 = categoryServer.getAll();
        listCommonResp1.setContent(categorys1);
        return  listCommonResp1;
    }
    @RequestMapping("/save")
    public CommonResp save(@Valid @RequestBody  CategorySaveReq categorySaveReq){
        CommonResp listCommonResp = new CommonResp<>();
        categoryServer.save(categorySaveReq);
        return  listCommonResp;
    }
    @RequestMapping("/delete/{id}")
    public CommonResp delete(@PathVariable long id){
        CommonResp listCommonResp = new CommonResp<>();
        categoryServer.delete(id);
        return  listCommonResp;
    }
}
