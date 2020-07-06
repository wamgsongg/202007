package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Companys", schema = "202007", catalog = "")
public class CompanysEntity {
    private int companyId;
    private String companyName;
    private String companyCode;
    private String companyLegal;
    private String companyContact;
    private String companyPhone;
    private String companyAddress;
    private String companyLocation;
    private String companyLogin;
    private String companyPwd;

    @Id
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_code")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Basic
    @Column(name = "company_legal")
    public String getCompanyLegal() {
        return companyLegal;
    }

    public void setCompanyLegal(String companyLegal) {
        this.companyLegal = companyLegal;
    }

    @Basic
    @Column(name = "company_contact")
    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    @Basic
    @Column(name = "company_phone")
    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    @Basic
    @Column(name = "company_address")
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "company_location")
    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    @Basic
    @Column(name = "company_login")
    public String getCompanyLogin() {
        return companyLogin;
    }

    public void setCompanyLogin(String companyLogin) {
        this.companyLogin = companyLogin;
    }

    @Basic
    @Column(name = "company_pwd")
    public String getCompanyPwd() {
        return companyPwd;
    }

    public void setCompanyPwd(String companyPwd) {
        this.companyPwd = companyPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanysEntity that = (CompanysEntity) o;
        return companyId == that.companyId &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(companyCode, that.companyCode) &&
                Objects.equals(companyLegal, that.companyLegal) &&
                Objects.equals(companyContact, that.companyContact) &&
                Objects.equals(companyPhone, that.companyPhone) &&
                Objects.equals(companyAddress, that.companyAddress) &&
                Objects.equals(companyLocation, that.companyLocation) &&
                Objects.equals(companyLogin, that.companyLogin) &&
                Objects.equals(companyPwd, that.companyPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, companyCode, companyLegal, companyContact, companyPhone, companyAddress, companyLocation, companyLogin, companyPwd);
    }
}
