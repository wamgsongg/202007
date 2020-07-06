package com.zucc.wsxbl.demo.formbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Companys {
    private int companyId;
    private String companyName;
    private String companyCode;
    private String companyLegal;//法人
    private String companyContact;//联络人
    private String companyPhone;//联络人电话
    private String companyAddress;//注册地址
    private String companyLocation;//地理位置
    private String companyLogin;
    private String companyPwd;
}
