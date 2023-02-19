package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {
    Employe findByRef(String ref);
    int deleteByRef(String ref);
}
