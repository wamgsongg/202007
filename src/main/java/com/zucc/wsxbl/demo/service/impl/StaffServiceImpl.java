package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.StaffEntity;
import com.zucc.wsxbl.demo.formbean.Staff;
import com.zucc.wsxbl.demo.repositories.StaffRepository;
import com.zucc.wsxbl.demo.service.StaffService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffRepository staffRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResultBean<Staff> staffRegister(Staff staff) {
        ResultBean<Staff> ret = new ResultBean<>();
        Staff s = Staff.builder().build();
        StaffEntity entity = new StaffEntity();
        if (staffRepository.existsStaffEntityByStaffLogin(staff.getStaffLogin())){
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("用户已存在");
        }else {
            MyBeanUtils.copyProperties(staff,entity);
            String hashedPassword = passwordEncoder.encode(staff.getStaffPwd());
            entity.setStaffPwd(hashedPassword);
            staffRepository.save(entity);
            MyBeanUtils.copyProperties(entity,s);
            ret.setData(s);
        }

        return ret;
    }

    @Override
    public ResultBean<Staff> staffLogin(String login, String pwd) {
        ResultBean<Staff> ret = new ResultBean<>();
        Staff s = Staff.builder().build();
        StaffEntity entity = new StaffEntity();

        entity = staffRepository.findStaffEntityByStaffLogin(login);
        if (entity!=null){
            boolean isMatch = passwordEncoder.matches(pwd, entity.getStaffPwd());
            if (isMatch){
                MyBeanUtils.copyProperties(entity,s);

                ret.setData(s);
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
}
