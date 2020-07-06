package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Checks", schema = "202007", catalog = "")
public class ChecksEntity {
    private int checkId;
    private Integer checkCorrect;
    private String checkStatus;
    private String checkOpinion;
    private String checkPerson;
    private Timestamp checkTime;

    @Id
    @Column(name = "check_id")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "check_correct")
    public Integer getCheckCorrect() {
        return checkCorrect;
    }

    public void setCheckCorrect(Integer checkCorrect) {
        this.checkCorrect = checkCorrect;
    }

    @Basic
    @Column(name = "check_status")
    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    @Basic
    @Column(name = "check_opinion")
    public String getCheckOpinion() {
        return checkOpinion;
    }

    public void setCheckOpinion(String checkOpinion) {
        this.checkOpinion = checkOpinion;
    }

    @Basic
    @Column(name = "check_person")
    public String getCheckPerson() {
        return checkPerson;
    }

    public void setCheckPerson(String checkPerson) {
        this.checkPerson = checkPerson;
    }

    @Basic
    @Column(name = "check_time")
    public Timestamp getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Timestamp checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChecksEntity that = (ChecksEntity) o;
        return checkId == that.checkId &&
                Objects.equals(checkCorrect, that.checkCorrect) &&
                Objects.equals(checkStatus, that.checkStatus) &&
                Objects.equals(checkOpinion, that.checkOpinion) &&
                Objects.equals(checkPerson, that.checkPerson) &&
                Objects.equals(checkTime, that.checkTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, checkCorrect, checkStatus, checkOpinion, checkPerson, checkTime);
    }
}
