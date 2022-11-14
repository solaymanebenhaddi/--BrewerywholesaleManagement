package com.brewery.manager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.BrewerieSales;

@Repository
public interface BrewerieSalesRepository extends JpaRepository<BrewerieSales,Long>  {


    @Query(value = "SELECT * FROM `beer_wholesaler` WHERE id_beer=?1 AND id_wholesale=?2",nativeQuery = true)
    public Optional<BrewerieSales>  getBrewerieSalesByIds(long id_beer,long id_wholesale);
}
