package com.brewery.manager.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.Wholesaler;

@Repository
public interface WholesaleRepository extends JpaRepository<Wholesaler,Long>{

//@Query(value = "",name = true)

    
}
