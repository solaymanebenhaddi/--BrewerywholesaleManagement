package com.brewery.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Brewerie;

@Repository
public interface BrewerieRepository extends JpaRepository<Brewerie,Long> {
    
}
