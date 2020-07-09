package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Staff", schema = "202007", catalog = "")
public class StaffEntity {
    private int staffId;
    private String staffName;
    private String staffPhone;
    private String staffCategory;
    private int staffCompany;
    private String staffLogin;
    private String staffPwd;

    @Id
    @Column(name = "staff_id")
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "staff_phone")
    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    @Basic
    @Column(name = "staff_category")
    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    @Basic
    @Column(name = "staff_company")
    public int getStaffCompany() {
        return staffCompany;
    }

    public void setStaffCompany(int staffCompany) {
        this.staffCompany = staffCompany;
    }

    @Basic
    @Column(name = "staff_login")
    public String getStaffLogin() {
        return staffLogin;
    }

    public void setStaffLogin(String staffLogin) {
        this.staffLogin = staffLogin;
    }

    @Basic
    @Column(name = "staff_pwd")
    public String getStaffPwd() {
        return staffPwd;
    }

    public void setStaffPwd(String staffPwd) {
        this.staffPwd = staffPwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return staffId == that.staffId &&
                Objects.equals(staffName, that.staffName) &&
                Objects.equals(staffPhone, that.staffPhone) &&
                Objects.equals(staffCategory, that.staffCategory) &&
                Objects.equals(staffCompany, that.staffCompany) &&
                Objects.equals(staffLogin, that.staffLogin) &&
                Objects.equals(staffPwd, that.staffPwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, staffPhone, staffCategory, staffCompany, staffLogin, staffPwd);
    }
}
