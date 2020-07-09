package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class Dangers {
    private int dangerId;
    private String dangerCompany;
    private String dangerCategory;
    private String dangerOrigin;//隐患源
    private String dangerLevel;
    private String dangerDes;//隐患描述
    private String dangerMeasures;//整改措施
    private int dangerP1;
    private int dangerP2;
    private int dangerP3;
    private int dangerDdl;//整改时限
    private String dangerFind;//排查人员
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dangerTime;//排查日期

}
