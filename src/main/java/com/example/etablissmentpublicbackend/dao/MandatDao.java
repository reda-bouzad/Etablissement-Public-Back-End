package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Mandat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MandatDao extends JpaRepository<Mandat , Long> {
    Mandat findByCode(String code);
    int deleteByCode(String code);
}
