package com.wang.wiki1.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wang.wiki1.config.Wiki1Application;
import com.wang.wiki1.domain.Ebook;
import com.wang.wiki1.domain.EbookExample;
import com.wang.wiki1.mapper.EbookMapper;
import com.wang.wiki1.req.EbookReq;
import com.wang.wiki1.resp.EbookQueryResp;
import com.wang.wiki1.resp.PageResp;
import com.wang.wiki1.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
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
    private static final Logger LOG = LoggerFactory.getLogger(Wiki1Application.class);

    public List<Ebook> list(){
        List<Ebook> list = ebookMapper.selectByExample(null);
        return  list;
    }
    public PageResp<EbookQueryResp> list2(EbookReq ebookReq){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria1 = ebookExample.createCriteria();
        if(!ObjectUtils.isEmpty(ebookReq.getName())){
            criteria1.andNameLike("%"+ebookReq.getName()+"%");
        }
        PageHelper.startPage(ebookReq.getStart(),ebookReq.getSize());
        List<Ebook> ebooks = ebookMapper.selectByExample(ebookExample);

        PageInfo<Ebook> pageinfo=new PageInfo<>(ebooks);
        List<EbookQueryResp> ebooks1 = CopyUtil.copyList(ebooks, EbookQueryResp.class);
        PageResp<EbookQueryResp> resp = new PageResp<>();
        resp.setList(ebooks1);
        resp.setTotal(pageinfo.getTotal());
        return resp;
    }
}
