package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.CategoriesEntity;
import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.repositories.CategoriesRepository;
import com.zucc.wsxbl.demo.service.CategoriesService;
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
        ResultBean<Categories> res = new ResultBean<>();
        CategoriesEntity entity = new CategoriesEntity();
        Categories categories = Categories.builder().build();
        entity = categoriesRepository.findByCategoryId(catid);
        if (entity!=null){
            BeanUtils.copyProperties(entity,categories);
            res.setData(categories);
        }else {
            res.setCode(ResultBean.FAIL);
            res.setMsg("不存在");
        }
        return res;
    }
}
