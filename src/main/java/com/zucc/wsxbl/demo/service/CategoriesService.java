package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface CategoriesService {
    ResultBean<Categories> getById(int catid);
    ResultBean<Categories> create(String name);
    ResultBean<Categories> delete(String name);
    ResultBean<Categories> update(String oldName,String newName);
}
