package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Staff;
import com.zucc.wsxbl.demo.utils.ResultBean;

import java.util.List;

public interface StaffService {
    ResultBean<Staff> staffRegister(Staff staff);
    ResultBean<Staff> staffLogin(String login,String pwd);
    ResultBean<Staff> staffAddCompany(int cid,String cat,String name);
    ResultBean<Staff> staffUpdate(Staff staff);
    ResultBean<List<Staff>> getByCompany(int cid);
}
