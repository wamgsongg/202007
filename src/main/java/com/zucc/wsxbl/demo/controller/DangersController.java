package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.service.DangersService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DangersController {
    @Autowired
    private DangersService dangersService;

    @PostMapping("/dangers/create")
    public ResultBean<Dangers> create(@RequestBody Dangers dangers){
        return dangersService.create(dangers);
    }
    @PostMapping("/dangers/delete")
    public ResultBean<Dangers> delete(@RequestBody Dangers dangers){
        return dangersService.delete(dangers);
    }


    @PostMapping("/dangers/update")
    public ResultBean<Dangers> upload(@RequestBody Dangers dangers){
        return dangersService.update(dangers);
    }
    @PostMapping("/dangers/getbycompany")
    public ResultBean<List<Dangers>> getByCompany(@RequestParam("companyName") String company){
        return dangersService.getByCompany(company);
    }
    @PostMapping("/dangers/getbycat")
    public ResultBean<List<Dangers>> getByCat(@RequestParam("companyCat") String cat){
        return dangersService.getByCat(cat);
    }
}
