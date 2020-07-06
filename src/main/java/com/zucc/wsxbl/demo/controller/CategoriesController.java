package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Categories;
import com.zucc.wsxbl.demo.service.CategoriesService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @PostMapping("/categories/getbyid")
    public ResultBean<Categories> getById(@RequestParam("categoryid") int categoryid){
        return categoriesService.getById(categoryid);
    }
}
