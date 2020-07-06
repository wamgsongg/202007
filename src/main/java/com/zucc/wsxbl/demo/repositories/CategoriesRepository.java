package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity,Integer> {
    CategoriesEntity findByCategoryId(int id);
}
