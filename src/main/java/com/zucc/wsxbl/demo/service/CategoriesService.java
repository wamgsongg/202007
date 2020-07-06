package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface CategoriesService {
    ResultBean<Categories> getById(int catid);
}
