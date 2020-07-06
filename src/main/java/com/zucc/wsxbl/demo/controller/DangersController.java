package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.service.DangersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DangersController {
    @Autowired
    private DangersService dangersService;
}
