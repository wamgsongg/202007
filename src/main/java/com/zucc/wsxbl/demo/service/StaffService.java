package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Staff;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface StaffService {
    ResultBean<Staff> staffRegister(Staff staff);
    ResultBean<Staff> staffLogin(String login,String pwd);
}
