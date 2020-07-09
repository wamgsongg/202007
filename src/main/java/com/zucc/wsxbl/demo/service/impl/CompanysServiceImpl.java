package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.CompanysEntity;
import com.zucc.wsxbl.demo.formbean.Companys;
import com.zucc.wsxbl.demo.repositories.CompanysRepository;
import com.zucc.wsxbl.demo.service.CompanysService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanysServiceImpl implements CompanysService {

    @Autowired
    private CompanysRepository companysRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String key = "d9df97648a1a416bbb1b4f088bd19446";
    private static final String token = "2227A4AEAD24659DABF09DCF030E2E68";


    @Override
    public ResultBean<Companys> companyRegister(Companys companys) {
        ResultBean<Companys> ret = new ResultBean<>();
        Companys company = Companys.builder().build();
        CompanysEntity entity = new CompanysEntity();
        if(companysRepository.existsCompanysEntityByCompanyLogin(companys.getCompanyLogin())){
            ret.setMsg("账号已存在");
            ret.setCode(ResultBean.FAIL);
        }else {
            MyBeanUtils.copyProperties(companys,entity);
            String hashedPassword = passwordEncoder.encode(companys.getCompanyPwd());
            entity.setCompanyPwd(hashedPassword);
            companysRepository.save(entity);
            MyBeanUtils.copyProperties(entity,company);
            ret.setData(company);
        }
        return ret;
    }

    @Override
    public ResultBean<Companys> companyLogin(String loginname, String pwd) {
        ResultBean<Companys> ret = new ResultBean<>();
        Companys company = Companys.builder().build();
        CompanysEntity entity = new CompanysEntity();

        entity = companysRepository.findCompanysEntityByCompanyLogin(loginname);
        if (entity!=null){
            boolean isMatch = passwordEncoder.matches(pwd, entity.getCompanyPwd());
            if (isMatch){
                MyBeanUtils.copyProperties(entity,company);

                ret.setData(company);
            }
            else {
                ret.setMsg("密码错误");
                ret.setCode(ResultBean.FAIL);
            }
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("账号不存在");

        }

        return ret;
    }

    @Override
    public ResultBean<Companys> companyUpdate(Companys companys) {
        ResultBean<Companys> ret = new ResultBean<>();
        CompanysEntity entity = new CompanysEntity();
        Companys c = Companys.builder().build();
        entity = companysRepository.findCompanysEntityByCompanyLogin(companys.getCompanyLogin());
        if (entity!=null){
             MyBeanUtils.copyProperties(companys,entity);
            companysRepository.save(entity);
            MyBeanUtils.copyProperties(entity,c);
            ret.setData(c);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }
        return  ret;
    }
}
