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
    @PostMapping("/category/create")
    public ResultBean<Categories> create(@RequestParam("name") String name){
        return categoriesService.create(name);
    }
    @PostMapping("/category/delete")
    public ResultBean<Categories> delete(@RequestParam("name") String name){
        return categoriesService.delete(name);
    }
    @PostMapping("/category/update")
    public ResultBean<Categories> update(@RequestParam("oldname") String oldname,@RequestParam("newname") String newname){
        return categoriesService.update(oldname,newname);
    }

}
