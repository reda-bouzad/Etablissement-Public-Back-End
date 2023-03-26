package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Echellon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EchellonDao extends JpaRepository<Echellon , Long> {
    List<Echellon> findByEchelleLibelle (String libelle);
    Echellon findByCode(String code);
    int deleteByCode(String code);
    int deleteByEchelleLibelle(String libelle);
}
