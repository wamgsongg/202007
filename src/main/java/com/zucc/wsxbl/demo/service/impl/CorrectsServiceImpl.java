package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.CorrectsEntity;
import com.zucc.wsxbl.demo.formbean.Corrects;
import com.zucc.wsxbl.demo.repositories.CorrectsRepository;
import com.zucc.wsxbl.demo.service.CorrectsService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrectsServiceImpl implements CorrectsService {

    @Autowired
    private CorrectsRepository correctsRepository;

    @Override
    public ResultBean<Corrects> create(Corrects corrects) {
        ResultBean<Corrects> ret = new ResultBean<>();
        Corrects c = Corrects.builder().build();
        CorrectsEntity entity = new CorrectsEntity();
        if (correctsRepository.existsCorrectsEntityByCorrectDanger(corrects.getCorrectDanger())){
            ret.setMsg("已排查");
            ret.setCode(ResultBean.FAIL);
        }else {
            MyBeanUtils.copyProperties(corrects,entity);
            correctsRepository.save(entity);
            entity = correctsRepository.findCorrectsEntityByCorrectDanger(corrects.getCorrectDanger());
            MyBeanUtils.copyProperties(entity,c);
            ret.setData(c);

        }

        return ret;
    }

    @Override
    public ResultBean<Corrects> delete(Corrects corrects) {
        ResultBean<Corrects> ret = new ResultBean<>();
        Corrects c = Corrects.builder().build();
        CorrectsEntity entity = new CorrectsEntity();

        return ret;
    }

    @Override
    public ResultBean<Corrects> update(Corrects corrects) {
        ResultBean<Corrects> ret = new ResultBean<>();
        Corrects c = Corrects.builder().build();
        CorrectsEntity entity = new CorrectsEntity();

        entity = correctsRepository.findCorrectsEntityByCorrectDanger(corrects.getCorrectDanger());
        if (entity!=null){
            MyBeanUtils.copyProperties(corrects,entity);
            correctsRepository.save(entity);
            entity  =  correctsRepository.findCorrectsEntityByCorrectDanger(corrects.getCorrectDanger());
            MyBeanUtils.copyProperties(entity,c);
            ret.setData(c);
        }else {
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }

        return ret;
    }

    @Override
    public ResultBean<Corrects> getByDanger(int danger) {
        ResultBean<Corrects> ret = new ResultBean<>();
        Corrects c = Corrects.builder().build();
        CorrectsEntity entity = new CorrectsEntity();
        entity = correctsRepository.findCorrectsEntityByCorrectDanger(danger);
        if (entity!=null){
            MyBeanUtils.copyProperties(entity,c);
            ret.setData(c);
        }else {
            ret.setMsg("fail");
            ret.setCode(ResultBean.FAIL);
        }

        return ret;
    }
}
