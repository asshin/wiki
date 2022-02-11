package com.wang.wiki1.service;

import com.wang.wiki1.config.Wiki1Application;
import com.wang.wiki1.domain.Category;
import com.wang.wiki1.domain.CategoryExample;
import com.wang.wiki1.mapper.CategoryMapper;
import com.wang.wiki1.req.CategoryQueryReq;
import com.wang.wiki1.req.CategorySaveReq;
import com.wang.wiki1.resp.CategoryQueryResp;
import com.wang.wiki1.resp.PageResp;
import com.wang.wiki1.util.CopyUtil;
import com.wang.wiki1.util.SnowFlake;
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
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    private static final Logger LOG = LoggerFactory.getLogger(Wiki1Application.class);

    public List<Category> list(){
        List<Category> list = categoryMapper.selectByExample(null);
        return  list;
    }
    public PageResp<CategoryQueryResp> list2(CategoryQueryReq categoryReq){
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria1 = categoryExample.createCriteria();
        List<Category> categorys = categoryMapper.selectByExample(categoryExample);
        List<CategoryQueryResp> categorys1 = CopyUtil.copyList(categorys, CategoryQueryResp.class);
        PageResp<CategoryQueryResp> resp = new PageResp<>();
        resp.setList(categorys1);
        return resp;
    }
    public void save( CategorySaveReq categorySaveReq){
        Category category=CopyUtil.copy(categorySaveReq,Category.class);
        if(ObjectUtils.isEmpty(category.getId())){
            SnowFlake snowFlake = new SnowFlake();
           category.setId(snowFlake.nextId());
           categoryMapper.insert(category);
        }else{
            categoryMapper.updateByPrimaryKey(category);
        }

    }

    public List<CategoryQueryResp> getAll(){
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.setOrderByClause("sort asc");
        List<Category> categorys = categoryMapper.selectByExample(categoryExample);
        List<CategoryQueryResp> categorys1 = CopyUtil.copyList(categorys, CategoryQueryResp.class);
        return categorys1;
    }
    public void delete( long id){
           categoryMapper.deleteByPrimaryKey(id);
    }
}
