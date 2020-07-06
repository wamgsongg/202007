package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.service.CompanysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanysController {

    @Autowired
    private CompanysService companysService;
}
