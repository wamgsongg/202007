package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.DangersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DangerRepository extends JpaRepository<DangersEntity,Integer> {
    Boolean existsDangersEntitiesByDangerCategory(String cat);
    DangersEntity findDangersEntityByDangerId(int id);
    List<DangersEntity> findDangersEntitiesByDangerCompany(int id);
    List<DangersEntity> findDangersEntitiesByDangerCategory(String cat);
}
