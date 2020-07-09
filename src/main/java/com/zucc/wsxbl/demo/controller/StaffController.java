package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Staff;
import com.zucc.wsxbl.demo.service.StaffService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffService staffService;

    @PostMapping("/staff/register")
    public ResultBean<Staff> staffRegister(@RequestBody Staff staff){
        return staffService.staffRegister(staff);
    }

    @PostMapping("/staff/login")
    public ResultBean<Staff> staffLogin(@RequestParam("login") String login,@RequestParam("pwd") String pwd){
        return staffService.staffLogin(login,pwd);
    }
    @PostMapping("/staff/addcompany")
    public ResultBean<Staff> staffAddCompany(@RequestParam("cid")int cid,@RequestParam("cat") String cat,@RequestParam("name")String name){
        return staffService.staffAddCompany(cid,cat,name);
    }
    @PostMapping("/staff/update")
    public ResultBean<Staff> staffUpdate(@RequestBody Staff staff){
        return staffService.staffUpdate(staff);
    }
    @PostMapping("/staff/getbycompany")
    public ResultBean<List<Staff>> getByCompany(@RequestParam("cid") int cid){
        return staffService.getByCompany(cid);
    }
}
