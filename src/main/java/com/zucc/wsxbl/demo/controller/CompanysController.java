package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Companys;
import com.zucc.wsxbl.demo.service.CompanysService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanysController {

    @Autowired
    private CompanysService companysService;

    @PostMapping("/companys/register")
    public ResultBean<Companys> companyRegister(@RequestBody Companys company){

        return companysService.companyRegister(company);
    }

    @PostMapping("/companys/login")
    public ResultBean<Companys> companyLogin(@RequestParam("login") String login,@RequestParam("pwd") String pwd){
        return companysService.companyLogin(login,pwd);
    }
    @PostMapping("/companys/update")
    public ResultBean<Companys> companyUpdate(@RequestBody Companys companys){
        return companysService.companyUpdate(companys);
    }

}
