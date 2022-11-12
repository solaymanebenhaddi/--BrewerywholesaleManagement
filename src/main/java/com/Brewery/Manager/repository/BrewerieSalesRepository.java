package com.brewery.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.BrewerieSales;

@Repository
public interface BrewerieSalesRepository extends JpaRepository<BrewerieSales,Long>  {


    @Query(value = "select* from ",nativeQuery = true)
    public BrewerieSales getBrewerieSalesByIds(long id_beer,long id_wholesale);
}
