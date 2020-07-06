package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.CategoriesEntity;
import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.repositories.CategoriesRepository;
import com.zucc.wsxbl.demo.service.CategoriesService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public ResultBean<Categories> getById(int catid) {
        ResultBean<Categories> ret = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();
        entity = categoriesRepository.findByCategoryId(catid);
        if (entity!=null){
            BeanUtils.copyProperties(entity,categories);
            ret.setData(categories);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("不存在");
        }
        return ret;
    }

    @Override
    public ResultBean<Categories> create(String name) {
        ResultBean<Categories> ret = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();
        if (categoriesRepository.existsCategoriesEntityByCategoryName(name)){
            ret.setMsg("分类已存在");
            ret.setCode(ResultBean.FAIL);

        }else {
            categories.setCategoryName(name);
            MyBeanUtils.copyProperties(categories,entity);
            categoriesRepository.save(entity);
            ret.setData(categories);
        }
        return ret;
    }

    @Override
    public ResultBean<Categories> delete(String name) {
        ResultBean<Categories> ret = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();
        if (categoriesRepository.existsCategoriesEntityByCategoryName(name)){
            entity = categoriesRepository.findCategoriesEntityByCategoryName(name);
            categoriesRepository.delete(entity);
             MyBeanUtils.copyProperties(entity,categories);
             ret.setData(categories);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("分类不存在");
        }
        return ret;
    }

    @Override
    public ResultBean<Categories> update(String oldName, String newName) {
        ResultBean<Categories> ret = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();

        if (categoriesRepository.existsCategoriesEntityByCategoryName(oldName)){
            entity = categoriesRepository.findCategoriesEntityByCategoryName(oldName);
            entity.setCategoryName(newName);
            categoriesRepository.save(entity);
            MyBeanUtils.copyProperties(entity,categories);
            ret.setData(categories);
        }else {
            ret.setMsg("分类不存在");
            ret.setCode(ResultBean.FAIL);
        }
        return ret;
    }
}
