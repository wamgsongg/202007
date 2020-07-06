package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class Corrects {
    private int correctId;
    private int correctDanger;
    private String correctStatus;
    private String correctMeasures;//整改措施
    private String correctDoc;//文档
    private String correctPerson;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date correctTime;
    private int correctP1;
    private int correctP2;
    private int correctP3;
}
