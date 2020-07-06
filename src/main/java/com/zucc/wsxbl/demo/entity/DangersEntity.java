package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Dangers", schema = "202007", catalog = "")
public class DangersEntity {
    private int dangerId;
    private String dangerCategory;
    private String dangerOrigin;
    private String dangerLevel;
    private String dangerDescription;
    private String dangerMeasures;
    private Integer dangerPhoto1;
    private Integer dangerPhoto2;
    private Integer dangerPhoto3;
    private Integer dangerDeadline;
    private String dangerFind;
    private Timestamp dangerTime;

    @Id
    @Column(name = "danger_id")
    public int getDangerId() {
        return dangerId;
    }

    public void setDangerId(int dangerId) {
        this.dangerId = dangerId;
    }

    @Basic
    @Column(name = "danger_category")
    public String getDangerCategory() {
        return dangerCategory;
    }

    public void setDangerCategory(String dangerCategory) {
        this.dangerCategory = dangerCategory;
    }

    @Basic
    @Column(name = "danger_origin")
    public String getDangerOrigin() {
        return dangerOrigin;
    }

    public void setDangerOrigin(String dangerOrigin) {
        this.dangerOrigin = dangerOrigin;
    }

    @Basic
    @Column(name = "danger_level")
    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Basic
    @Column(name = "danger_description")
    public String getDangerDescription() {
        return dangerDescription;
    }

    public void setDangerDescription(String dangerDescription) {
        this.dangerDescription = dangerDescription;
    }

    @Basic
    @Column(name = "danger_measures")
    public String getDangerMeasures() {
        return dangerMeasures;
    }

    public void setDangerMeasures(String dangerMeasures) {
        this.dangerMeasures = dangerMeasures;
    }

    @Basic
    @Column(name = "danger_photo1")
    public Integer getDangerPhoto1() {
        return dangerPhoto1;
    }

    public void setDangerPhoto1(Integer dangerPhoto1) {
        this.dangerPhoto1 = dangerPhoto1;
    }

    @Basic
    @Column(name = "danger_photo2")
    public Integer getDangerPhoto2() {
        return dangerPhoto2;
    }

    public void setDangerPhoto2(Integer dangerPhoto2) {
        this.dangerPhoto2 = dangerPhoto2;
    }

    @Basic
    @Column(name = "danger_photo3")
    public Integer getDangerPhoto3() {
        return dangerPhoto3;
    }

    public void setDangerPhoto3(Integer dangerPhoto3) {
        this.dangerPhoto3 = dangerPhoto3;
    }

    @Basic
    @Column(name = "danger_deadline")
    public Integer getDangerDeadline() {
        return dangerDeadline;
    }

    public void setDangerDeadline(Integer dangerDeadline) {
        this.dangerDeadline = dangerDeadline;
    }

    @Basic
    @Column(name = "danger_find")
    public String getDangerFind() {
        return dangerFind;
    }

    public void setDangerFind(String dangerFind) {
        this.dangerFind = dangerFind;
    }

    @Basic
    @Column(name = "danger_time")
    public Timestamp getDangerTime() {
        return dangerTime;
    }

    public void setDangerTime(Timestamp dangerTime) {
        this.dangerTime = dangerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DangersEntity that = (DangersEntity) o;
        return dangerId == that.dangerId &&
                Objects.equals(dangerCategory, that.dangerCategory) &&
                Objects.equals(dangerOrigin, that.dangerOrigin) &&
                Objects.equals(dangerLevel, that.dangerLevel) &&
                Objects.equals(dangerDescription, that.dangerDescription) &&
                Objects.equals(dangerMeasures, that.dangerMeasures) &&
                Objects.equals(dangerPhoto1, that.dangerPhoto1) &&
                Objects.equals(dangerPhoto2, that.dangerPhoto2) &&
                Objects.equals(dangerPhoto3, that.dangerPhoto3) &&
                Objects.equals(dangerDeadline, that.dangerDeadline) &&
                Objects.equals(dangerFind, that.dangerFind) &&
                Objects.equals(dangerTime, that.dangerTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dangerId, dangerCategory, dangerOrigin, dangerLevel, dangerDescription, dangerMeasures, dangerPhoto1, dangerPhoto2, dangerPhoto3, dangerDeadline, dangerFind, dangerTime);
    }
}
