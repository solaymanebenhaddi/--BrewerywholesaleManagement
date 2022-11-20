package com.brewery.manager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brewery.manager.models.QuateandBeersHouseIDs;
import com.brewery.manager.models.QuoteBeerInWrhouse;

@Repository
public interface QuoteBrInWhouseRespository extends JpaRepository<QuoteBeerInWrhouse,QuateandBeersHouseIDs> {

    

@Query (value = "SELECT q.* FROM qoute_beer q , quote u WHERE q.id_devis=u.id_devis and q.id_devis=?1",nativeQuery = true)
List<QuoteBeerInWrhouse> getQuoteBeerByQuoteID(Long id_quote);



@Query (value = "SELECT qb.* FROM qoute_beer qb WHERE qb.id_devis=?1 and qb.id_beer=?2",nativeQuery = true)
Optional<QuoteBeerInWrhouse> isQuotehasBeer(Long id_quote,long id_beer);

@Query (value = "SELECT qb.* FROM qoute_beer qb WHERE qb.id_devis=?1",nativeQuery = true)
List<QuoteBeerInWrhouse> getAllQuoteByIdquote(Long id_quote);
    
}
