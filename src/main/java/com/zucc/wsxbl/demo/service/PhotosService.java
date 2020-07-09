package com.zucc.wsxbl.demo.service;

import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.formbean.Photos;
import com.zucc.wsxbl.demo.utils.ResultBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public interface PhotosService {
    ResultBean<Photos> uploadPhoto (MultipartFile file, String uploadDir, Date time, String person, String loc);

}
