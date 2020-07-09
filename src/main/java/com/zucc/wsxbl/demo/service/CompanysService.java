package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Companys;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface CompanysService {
    ResultBean<Companys> companyRegister(Companys companys);
    ResultBean<Companys> companyLogin(String loginname,String pwd);
    ResultBean<Companys> companyUpdate(Companys companys);
}
