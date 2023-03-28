package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {
    Employe findByCin(String cin);
    int deleteByCin(String cin);
    List<Employe> findByEntiteAdministratifCode(String code);
    int deleteByEntiteAdministratifCode(String code);


}
