package com.example.etablissmentpublicbackend.dao;

import com.example.etablissmentpublicbackend.bean.Avancement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
    @Repository
    public interface AvancementDao extends JpaRepository<Avancement , Long>{

    }
