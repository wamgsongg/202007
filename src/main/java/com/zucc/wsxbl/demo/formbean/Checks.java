package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
public class Checks {
    private int checkId;
    private int checkCorrect;
    private String checkStatus;
    private String checkOpinion;
    private String checkPerson;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

}
