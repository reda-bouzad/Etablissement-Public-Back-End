package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeDao extends JpaRepository<Grade , Long> {
    Grade findByCode(String code);
    int deleteByCode(String code);
}
