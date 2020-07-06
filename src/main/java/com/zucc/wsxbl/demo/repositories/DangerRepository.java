package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.DangersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DangerRepository extends JpaRepository<DangersEntity,Integer> {
    Boolean existsDangersEntitiesByDangerCategory(String cat);
}
