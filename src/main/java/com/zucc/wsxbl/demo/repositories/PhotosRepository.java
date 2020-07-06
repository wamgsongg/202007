package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.PhotosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<PhotosEntity,Integer> {

}
