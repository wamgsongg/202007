package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.CompanysEntity;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanysRepository extends JpaRepository<CompanysEntity,Integer> {

    Boolean existsCompanysEntityByCompanyName(String name);
    Boolean existsCompanysEntityByCompanyLogin(String login);
    CompanysEntity findCompanysEntityByCompanyLogin(String login);
}
