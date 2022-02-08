package com.wang.wiki1.service;

import com.wang.wiki1.domain.Demo;
import com.wang.wiki1.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @create 2022-02-08 16:11
 */

@Service
public class DemoService {
    @Resource
    private DemoMapper demoMapper;
    public List<Demo> list(){
        List<Demo> list = demoMapper.selectByExample(null);
        return  list;
    }
}
