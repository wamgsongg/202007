package com.zucc.wsxbl.demo.service;


import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.utils.ResultBean;

import java.util.List;

public interface DangersService {
    ResultBean<Dangers> create(Dangers dangers);
    ResultBean<Dangers> delete(Dangers dangers);
    ResultBean<Dangers> update(Dangers dangers);
    ResultBean<List<Dangers>> getByCompany(int company);
    ResultBean<List<Dangers>> getByCat(String cat);
}
