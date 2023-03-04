package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.DetailSalaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detail_SalaireDao extends JpaRepository<DetailSalaire, Long> {
    DetailSalaire findByCode(String code);
    int deleteByCode(String code);

}
