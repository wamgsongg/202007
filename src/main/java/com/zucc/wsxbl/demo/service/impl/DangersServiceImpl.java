package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.CompanysEntity;
import com.zucc.wsxbl.demo.entity.DangersEntity;
import com.zucc.wsxbl.demo.entity.PhotosEntity;
import com.zucc.wsxbl.demo.formbean.Companys;
import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.formbean.Photos;
import com.zucc.wsxbl.demo.repositories.CompanysRepository;
import com.zucc.wsxbl.demo.repositories.DangerRepository;
import com.zucc.wsxbl.demo.repositories.PhotosRepository;
import com.zucc.wsxbl.demo.service.DangersService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DangersServiceImpl implements DangersService {

    @Autowired
    private DangerRepository dangerRepository;


    @Override
    public ResultBean<Dangers> create(Dangers dangers) {
        ResultBean<Dangers> ret = new ResultBean<>();
        //Dangers d = Dangers.builder().build();
        DangersEntity entity = new DangersEntity();

        MyBeanUtils.copyProperties(dangers,entity);
        dangerRepository.save(entity);

        return ret;
    }

    @Override
    public ResultBean<Dangers> delete(Dangers dangers) {
        ResultBean<Dangers> ret = new ResultBean<>();
       // Dangers d = Dangers.builder().build();
        DangersEntity entity = new DangersEntity();
        MyBeanUtils.copyProperties(dangers,entity);
        dangerRepository.delete(entity);

        return ret;
    }

    @Override
    public ResultBean<Dangers> update(Dangers dangers) {
        ResultBean<Dangers> ret = new ResultBean<>();
        Dangers d = Dangers.builder().build();
        DangersEntity entity = new DangersEntity();
        entity = dangerRepository.findDangersEntityByDangerId(dangers.getDangerId());
        if (entity!=null) {
            MyBeanUtils.copyProperties(dangers, entity);
            dangerRepository.save(entity);
            entity = dangerRepository.findDangersEntityByDangerId(dangers.getDangerId());
            MyBeanUtils.copyProperties(entity, d);
            ret.setData(d);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }
        return ret;
    }

    @Override
    public ResultBean<List<Dangers>> getByCompany(String company) {
        ResultBean<List<Dangers>> ret = new ResultBean<>();

        List<Dangers> list = new ArrayList<>();
        List<DangersEntity> entities  =new ArrayList<>();
        entities = dangerRepository.findDangersEntitiesByDangerCompany(company);
        if (entities!=null){
            for(DangersEntity e : entities){
                Dangers d = Dangers.builder().build();
                MyBeanUtils.copyProperties(e,d);
                list.add(d);
            }
            ret.setData(list);
        }else {
            ret.setMsg("fail");
            ret.setCode(ResultBean.FAIL);
        }


        return ret;
    }

    @Override
    public ResultBean<List<Dangers>> getByCat(String cat) {
        ResultBean<List<Dangers>> ret = new ResultBean<>();

        List<Dangers> list = new ArrayList<>();
        List<DangersEntity> entities  =new ArrayList<>();
        entities = dangerRepository.findDangersEntitiesByDangerCategory(cat);
        if (entities!=null){
            for (DangersEntity e : entities){
                Dangers d  = Dangers.builder().build();
                MyBeanUtils.copyProperties(e,d);
                list.add(d);
            }
            ret.setData(list);
        }else {
            ret.setMsg("fail");
            ret.setCode(ResultBean.FAIL);
        }

        return ret;
    }
}
