package com.wang.wiki1.service;

import com.wang.wiki1.domain.Test;
import com.wang.wiki1.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @create 2022-02-08 14:55
 */
@Service
public class TestService {
    @Resource
    private TestMapper testMapper;
    public List<Test> list(){
        List<Test> list = testMapper.list();
        return  list;
    }
}
