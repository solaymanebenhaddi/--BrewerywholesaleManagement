package com.brewery.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.QuateandBeersHouseIDs;
import com.brewery.manager.models.QuoteBeerInWrhouse;

@Repository
public interface QuoteBrInWhouseRespository extends JpaRepository<QuoteBeerInWrhouse,QuateandBeersHouseIDs> {

    
    
}
