package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.utils.ResultBean;

import java.util.List;

public interface CategoriesService {
    ResultBean<Categories> getById(int catid);
    ResultBean<Categories> create(String name);
    ResultBean<Categories> delete(String name);
    ResultBean<Categories> update(int id,String name);
    ResultBean<List<Categories>> getAll();
}
