package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Echellon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchellonDao extends JpaRepository<Echellon , Long> {
    Echellon findByCode(String code);
    int deleteByCode(String code);
}
