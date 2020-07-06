package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.StaffEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {
    Boolean existsStaffEntityByStaffLogin(String login);
    StaffEntity findStaffEntityByStaffLogin(String login);
}
