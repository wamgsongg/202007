package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Corrects", schema = "202007", catalog = "")
public class CorrectsEntity {
    private int correctId;
    private Integer correctDanger;
    private String correctStatus;
    private String correctMeasures;
    private String correctDocument;
    private String correctPerson;
    private Timestamp correctTime;
    private Integer correctPhoto1;
    private Integer correctPhoto2;
    private Integer correctPhoto3;

    @Id
    @Column(name = "correct_id")
    public int getCorrectId() {
        return correctId;
    }

    public void setCorrectId(int correctId) {
        this.correctId = correctId;
    }

    @Basic
    @Column(name = "correct_danger")
    public Integer getCorrectDanger() {
        return correctDanger;
    }

    public void setCorrectDanger(Integer correctDanger) {
        this.correctDanger = correctDanger;
    }

    @Basic
    @Column(name = "correct_status")
    public String getCorrectStatus() {
        return correctStatus;
    }

    public void setCorrectStatus(String correctStatus) {
        this.correctStatus = correctStatus;
    }

    @Basic
    @Column(name = "correct_measures")
    public String getCorrectMeasures() {
        return correctMeasures;
    }

    public void setCorrectMeasures(String correctMeasures) {
        this.correctMeasures = correctMeasures;
    }

    @Basic
    @Column(name = "correct_document")
    public String getCorrectDocument() {
        return correctDocument;
    }

    public void setCorrectDocument(String correctDocument) {
        this.correctDocument = correctDocument;
    }

    @Basic
    @Column(name = "correct_person")
    public String getCorrectPerson() {
        return correctPerson;
    }

    public void setCorrectPerson(String correctPerson) {
        this.correctPerson = correctPerson;
    }

    @Basic
    @Column(name = "correct_time")
    public Timestamp getCorrectTime() {
        return correctTime;
    }

    public void setCorrectTime(Timestamp correctTime) {
        this.correctTime = correctTime;
    }

    @Basic
    @Column(name = "correct_photo1")
    public Integer getCorrectPhoto1() {
        return correctPhoto1;
    }

    public void setCorrectPhoto1(Integer correctPhoto1) {
        this.correctPhoto1 = correctPhoto1;
    }

    @Basic
    @Column(name = "correct_photo2")
    public Integer getCorrectPhoto2() {
        return correctPhoto2;
    }

    public void setCorrectPhoto2(Integer correctPhoto2) {
        this.correctPhoto2 = correctPhoto2;
    }

    @Basic
    @Column(name = "correct_photo3")
    public Integer getCorrectPhoto3() {
        return correctPhoto3;
    }

    public void setCorrectPhoto3(Integer correctPhoto3) {
        this.correctPhoto3 = correctPhoto3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrectsEntity that = (CorrectsEntity) o;
        return correctId == that.correctId &&
                Objects.equals(correctDanger, that.correctDanger) &&
                Objects.equals(correctStatus, that.correctStatus) &&
                Objects.equals(correctMeasures, that.correctMeasures) &&
                Objects.equals(correctDocument, that.correctDocument) &&
                Objects.equals(correctPerson, that.correctPerson) &&
                Objects.equals(correctTime, that.correctTime) &&
                Objects.equals(correctPhoto1, that.correctPhoto1) &&
                Objects.equals(correctPhoto2, that.correctPhoto2) &&
                Objects.equals(correctPhoto3, that.correctPhoto3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctId, correctDanger, correctStatus, correctMeasures, correctDocument, correctPerson, correctTime, correctPhoto1, correctPhoto2, correctPhoto3);
    }
}
