package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Echelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchelleDao extends JpaRepository<Echelle,Long> {
    Echelle findByCode(String code);
    int deleteByCode(String code);
}
