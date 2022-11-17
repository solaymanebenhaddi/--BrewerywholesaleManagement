package com.brewery.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Quote;

@Repository
public interface QuoteRepository  extends JpaRepository<Quote,Long>{
    
}
