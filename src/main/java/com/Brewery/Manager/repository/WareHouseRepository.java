package com.brewery.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Warehouse;

@Repository
public interface WareHouseRepository extends JpaRepository<Warehouse,Long> {

    @Query(value = "SELECT * FROM warehouse WHERE id_warehouse=?1 AND wholesaler_id_wholesale=?2 ",nativeQuery = true)
    public Optional<Warehouse> finbyidandWholeseller(long id_warehouse,long id_wholesaler);
    
}
