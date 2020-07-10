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

import java.util.ArrayList;
import java.util.List;

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
            entity = staffRepository.findStaffEntityByStaffLogin(staff.getStaffLogin());
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

    @Override
    public ResultBean<Staff> staffAddCompany(int cid, String cat, String name) {
        ResultBean<Staff> ret = new ResultBean<>();
        Staff staff = Staff.builder().build();
        StaffEntity entity = new StaffEntity();
        entity = staffRepository.findStaffEntityByStaffLogin(name);
        if (entity!=null){
            entity.setStaffCategory(cat);
            entity.setStaffCompany(cid);
            staffRepository.save(entity);
            MyBeanUtils.copyProperties(entity,staff);
            ret.setData(staff);
        }else {
            ret.setMsg("fail");
            ret.setCode(ResultBean.FAIL);
        }

        return ret;
    }

    @Override
    public ResultBean<Staff> staffUpdate(Staff staff) {
        ResultBean<Staff> ret = new ResultBean<>();
        StaffEntity entity = new StaffEntity();
        Staff s = Staff.builder().build();
        entity = staffRepository.findStaffEntityByStaffLogin(staff.getStaffLogin());
        if (entity!=null&&staff.getStaffId()!=0){
            MyBeanUtils.copyProperties(staff,entity);
            staffRepository.save(entity);
            MyBeanUtils.copyProperties(entity,s);
            ret.setData(s);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }

        return ret;
    }

    @Override
    public ResultBean<List<Staff>> getByCompany(int cid) {
        ResultBean<List<Staff>> ret = new ResultBean<>();
        List<Staff> list = new ArrayList<>();
        List<StaffEntity> entities = new ArrayList<>();
        entities = staffRepository.findStaffEntitiesByStaffCompany(cid);
        if (entities!=null){
            for(StaffEntity entity : entities){
                Staff s = Staff.builder().build();
                MyBeanUtils.copyProperties(entity,s);
                list.add(s);
            }
            ret.setData(list);
        }else {
            ret.setMsg("fail");
            ret.setCode(ResultBean.FAIL);
        }
        return ret;
    }
}
