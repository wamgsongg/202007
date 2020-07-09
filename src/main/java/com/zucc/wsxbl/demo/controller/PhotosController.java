package com.zucc.wsxbl.demo.controller;

import com.zucc.wsxbl.demo.formbean.Photos;
import com.zucc.wsxbl.demo.service.PhotosService;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
public class PhotosController {

    @Autowired
    private PhotosService photosService;

    @PostMapping("/photo/upload")
    public ResultBean<Photos> upload(@RequestParam("file")MultipartFile file, @RequestParam("time")Date date,@RequestParam("person") String person,@RequestParam("location")String loc){
        return photosService.uploadPhoto(file,"../../../../../../resources/static/photos",date,person,loc);
    }
}
