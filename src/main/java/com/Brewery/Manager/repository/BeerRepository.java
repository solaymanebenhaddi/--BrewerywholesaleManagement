package com.brewery.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Beer;

@Repository
public interface BeerRepository extends JpaRepository<Beer,Long> {

    @Query(value = "select * from beer",nativeQuery = true)
    List<Beer> findallBeers();
    
    @Query(value = "select * from beer where id_brewerie=?1",nativeQuery = true)
    List<Beer> findallBeersByBrewerieId(Long IdBrew);
}
