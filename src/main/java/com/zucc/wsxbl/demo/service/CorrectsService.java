package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Corrects;
import com.zucc.wsxbl.demo.utils.ResultBean;

public interface CorrectsService {
    ResultBean<Corrects> create(Corrects corrects);
    ResultBean<Corrects> delete(Corrects corrects);
    ResultBean<Corrects> update(Corrects corrects);
    ResultBean<Corrects> getByDanger(int danger);
}
