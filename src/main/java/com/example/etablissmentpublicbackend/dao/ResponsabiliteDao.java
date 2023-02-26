package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Responsabilite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsabiliteDao extends JpaRepository<Responsabilite , Long> {
    Responsabilite findByLibelle(String libelle);
    Responsabilite findByCode(String code);
    int deleteByLibelle(String libelle);
    int deleteByCode(String code);

}
