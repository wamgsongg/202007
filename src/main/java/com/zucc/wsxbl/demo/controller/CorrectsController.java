package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Corrects;
import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.service.CorrectsService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CorrectsController {

    @Autowired
    private CorrectsService correctsService;
    @PostMapping("/corrects/create")
    public ResultBean<Corrects> create(@RequestBody Corrects corrects){
        return correctsService.create(corrects);
    }
    @PostMapping("/corrects/delete")
    public ResultBean<Corrects> delete(@RequestBody Corrects corrects){
        return correctsService.delete(corrects);
    }
    @PostMapping("/corrects/update")
    public ResultBean<Corrects> update(@RequestBody Corrects corrects){
        return correctsService.update(corrects);
    }
    @PostMapping("/corrects/getbydanger")
    public ResultBean<Corrects> getByDanger(@RequestParam("dangerId") int did){
        return correctsService.getByDanger(did);
    }
}
