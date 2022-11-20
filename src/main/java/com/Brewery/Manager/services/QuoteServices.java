package com.brewery.manager.services;

import java.time.LocalDate;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.models.Quote;
import com.brewery.manager.repository.QuoteRepository;
import com.brewery.manager.util.ResourceNotFoundException;
@Transactional
@Service
public class QuoteServices {

    @Autowired
    private QuoteRepository quoteRepository;

    public ResponseEntity<?> NewQuote() throws Exception {
        try {
            Quote newquote = new Quote();
            newquote.setDateqoute(LocalDate.now());
            quoteRepository.save(newquote);
            return ResponseEntity.ok(newquote);
        } catch (Exception e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

}
