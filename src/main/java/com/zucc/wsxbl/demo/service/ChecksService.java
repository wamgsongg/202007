package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Checks;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface ChecksService {
    ResultBean<Checks> create(Checks checks);
    ResultBean<Checks> delete(Checks checks);
    ResultBean<Checks> update(Checks checks);
    ResultBean<Checks> getByCorrect(int correct);

}
