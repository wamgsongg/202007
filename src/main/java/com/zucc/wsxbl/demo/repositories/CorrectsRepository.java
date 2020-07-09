package com.zucc.wsxbl.demo.repositories;

import com.zucc.wsxbl.demo.entity.CorrectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrectsRepository extends JpaRepository<CorrectsEntity,Integer> {
    Boolean existsCorrectsEntityByCorrectDanger(int id);
    CorrectsEntity findCorrectsEntityByCorrectId(int id);
    CorrectsEntity findCorrectsEntityByCorrectDanger(int id);


}
