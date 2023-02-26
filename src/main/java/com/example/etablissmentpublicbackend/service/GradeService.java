package com.example.etablissmentpublicbackend.service;

import com.example.etablissmentpublicbackend.bean.Grade;
import com.example.etablissmentpublicbackend.dao.GradeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeDao gradeDao;

    public Grade findByCode(String code) {
        return gradeDao.findByCode(code);
    }

    public int deleteByCode(String code) {
        return gradeDao.deleteByCode(code);
    }

    public List<Grade> findAll() {
        return gradeDao.findAll();
    }
}
