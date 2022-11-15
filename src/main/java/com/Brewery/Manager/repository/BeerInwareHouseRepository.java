package com.brewery.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.BeerInWarehouse;


@Repository
public interface BeerInwareHouseRepository extends JpaRepository<BeerInWarehouse,Long> {

    

    @Query(value = "SELECT * FROM beer_in_warehouse WHERE id_beer=?1 AND id_warehouse=?2 ",nativeQuery = true)
    public Optional<BeerInWarehouse> getByIds(long id_beer, Long id_warehouse);
}
