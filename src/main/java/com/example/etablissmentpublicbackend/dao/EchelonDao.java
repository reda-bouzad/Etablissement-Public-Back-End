package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Echelon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchelonDao extends JpaRepository<Echelon, Long> {
    Echelon findByCode(String code);
    int deleteByCode(String code);
}
