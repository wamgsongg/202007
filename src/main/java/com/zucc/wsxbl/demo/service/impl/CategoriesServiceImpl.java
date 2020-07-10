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

import java.util.ArrayList;
import java.util.List;

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
            entity.setCategoryName(name);
            categoriesRepository.save(entity);
            entity = categoriesRepository.findCategoriesEntityByCategoryName(name);
            MyBeanUtils.copyProperties(entity,categories);
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
    public ResultBean<Categories> update(int id, String name) {
        ResultBean<Categories> ret = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();
        entity=categoriesRepository.findByCategoryId(id);
        if (entity!=null){
            entity.setCategoryName(name);
            categoriesRepository.save(entity);
            MyBeanUtils.copyProperties(entity,categories);
            ret.setData(categories);
        }else {
            ret.setMsg("分类不存在");
            ret.setCode(ResultBean.FAIL);
        }
        return ret;
    }

    @Override
    public ResultBean<List<Categories>> getAll() {
        ResultBean<List<Categories>> ret = new ResultBean<>();
        List<Categories> list = new ArrayList<>();
        List<CategoriesEntity> entities = categoriesRepository.findAll();
        if (entities!=null){
            for (CategoriesEntity entity:entities){
                Categories category = Categories.builder().build();
                MyBeanUtils.copyProperties(entity,category);
                list.add(category);
            }
            ret.setData(list);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }
        return  ret;
    }
}
