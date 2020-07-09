package com.zucc.wsxbl.demo.service.impl;

import com.zucc.wsxbl.demo.entity.PhotosEntity;
import com.zucc.wsxbl.demo.formbean.Dangers;
import com.zucc.wsxbl.demo.formbean.Photos;
import com.zucc.wsxbl.demo.repositories.PhotosRepository;
import com.zucc.wsxbl.demo.service.PhotosService;
import com.zucc.wsxbl.demo.utils.MyBeanUtils;
import com.zucc.wsxbl.demo.utils.ResultBean;
import com.zucc.wsxbl.demo.utils.TimeTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import java.util.UUID;

@Service
public class PhotosServiceImpl implements PhotosService {

    @Autowired
    private PhotosRepository photosRepository;

    @Override
    public ResultBean<Photos> uploadPhoto(MultipartFile file, String uploadDir, Date time,String person,String loc) {
        ResultBean<Photos> ret = new ResultBean<>();
        Photos photos = Photos.builder().build();
        TimeTransform tt = new TimeTransform();

        PhotosEntity photosEntity = new PhotosEntity();
        try {
            String imgUrl = null;
            MultipartFile add = addMark(file,tt.date2String(time)+" "+loc+" "+person);
            String filename = upload(add,uploadDir,file.getOriginalFilename());
            if (!filename.isEmpty()){
                imgUrl = new File(uploadDir).getName() + "/" +filename;
            }
            if (imgUrl!=null){
                MyBeanUtils.copyProperties(photos,photosEntity);
                photosEntity.setPhotoCode(imgUrl);
                photosEntity.setPhotoLocation(loc);
                photosEntity.setPhotoPerson(person);
                photosEntity.setPhotoTime(tt.string2Timestamp(tt.date2String(time)));
                photosRepository.save(photosEntity);
                photosEntity = photosRepository.findPhotosEntityByPhotoCode(imgUrl);

                MyBeanUtils.copyProperties(photosEntity,photos);
                ret.setData(photos);

            }

        } catch (Exception e) {
            e.printStackTrace();
            ret.setCode(ResultBean.FAIL);
            ret.setMsg("fail");
        }

        return ret;
    }


    public String upload(MultipartFile file,String path,String fileName) throws Exception{
        String realPath = path + "/" + UUID.randomUUID().toString().replace("-","") + fileName.substring(fileName.lastIndexOf("."));
        File dest = new File(realPath);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        file.transferTo(dest);
        return fileName;
    }
    public static MultipartFile addMark(MultipartFile multipartFile,String word) throws IOException {
        String originFileName = multipartFile.getOriginalFilename();
        int lastSplit = originFileName.lastIndexOf(".");
        String suffix = originFileName.substring(lastSplit + 1);
        String dOriginFileName = multipartFile.getOriginalFilename();
        String dContentType = multipartFile.getContentType();
        if (!suffix.equalsIgnoreCase("gif")&&dContentType.contains("image")){
            InputStream inputImg = multipartFile.getInputStream();
            Image img = ImageIO.read(inputImg);
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);

            BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight,
                    BufferedImage.TYPE_INT_RGB);
            //设置字体
            Font font = new Font("宋体", Font.PLAIN, 14);
            //调用画文字水印的方法
            markWord(bufImg, img, word, font , Color.RED, 0, 14);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
            ImageIO.write(bufImg, suffix, imOut);
            InputStream is = new ByteArrayInputStream(bs.toByteArray());

            // 加水印后的文件上传
            multipartFile = new MockMultipartFile(dOriginFileName, dOriginFileName, dContentType,
                    is);
      }
        return multipartFile;
    }
    public static void markWord(BufferedImage bufImg, Image img, String text, Font font, Color color, int x, int y) {
        //取到画笔
        Graphics2D g = bufImg.createGraphics();
        //画底片
        g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
        g.setColor(color);
        g.setFont(font);
        //位置
        g.drawString(text, x, y);
        g.dispose();
    }


}
