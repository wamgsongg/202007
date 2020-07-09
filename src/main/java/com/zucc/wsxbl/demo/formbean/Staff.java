package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Staff {
    private int staffId;
    private String staffName;
    private String staffPhoto;
    private String staffCategory;
    private int staffCompany;
    private String staffLogin;
    private String staffPwd;
}
