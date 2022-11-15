package com.brewery.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Warehouse;

@Repository
public interface WareHouseRepository extends JpaRepository<Warehouse,Long> {
    
}
