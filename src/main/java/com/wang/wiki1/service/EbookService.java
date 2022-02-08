package com.wang.wiki1.service;

import com.wang.wiki1.domain.Ebook;
import com.wang.wiki1.mapper.EbookMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @create 2022-02-08 16:31
 */
@RestController
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;
    public List<Ebook> list(){
        List<Ebook> list = ebookMapper.selectByExample(null);
        return  list;
    }
}
