package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;
}
