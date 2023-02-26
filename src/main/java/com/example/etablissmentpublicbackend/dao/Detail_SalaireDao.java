package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Detail_Salaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detail_SalaireDao extends JpaRepository<Detail_Salaire , Long> {
    Detail_Salaire findByCode(String code);
    int deleteByCode(String code);

}
