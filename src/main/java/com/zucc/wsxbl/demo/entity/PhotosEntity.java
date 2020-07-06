package com.zucc.wsxbl.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Photos", schema = "202007", catalog = "")
public class PhotosEntity {
    private int photoId;
    private String photoCode;
    private Timestamp photoTime;
    private String photoPerson;
    private String photoLocation;

    @Id
    @Column(name = "photo_id")
    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Basic
    @Column(name = "photo_code")
    public String getPhotoCode() {
        return photoCode;
    }

    public void setPhotoCode(String photoCode) {
        this.photoCode = photoCode;
    }

    @Basic
    @Column(name = "photo_time")
    public Timestamp getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(Timestamp photoTime) {
        this.photoTime = photoTime;
    }

    @Basic
    @Column(name = "photo_person")
    public String getPhotoPerson() {
        return photoPerson;
    }

    public void setPhotoPerson(String photoPerson) {
        this.photoPerson = photoPerson;
    }

    @Basic
    @Column(name = "photo_location")
    public String getPhotoLocation() {
        return photoLocation;
    }

    public void setPhotoLocation(String photoLocation) {
        this.photoLocation = photoLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhotosEntity that = (PhotosEntity) o;
        return photoId == that.photoId &&
                Objects.equals(photoCode, that.photoCode) &&
                Objects.equals(photoTime, that.photoTime) &&
                Objects.equals(photoPerson, that.photoPerson) &&
                Objects.equals(photoLocation, that.photoLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photoId, photoCode, photoTime, photoPerson, photoLocation);
    }
}
