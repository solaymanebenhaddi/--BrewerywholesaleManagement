package com.brewery.manager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.manager.models.QuoteBeerInWrhouse;
import com.brewery.manager.payload.request.QuoteBrInWHouseRequest;
import com.brewery.manager.services.QuoteBeerinWHosService;

import lombok.val;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/quote")
public class QuoteController{

    @Autowired
    private QuoteBeerinWHosService quoteBeerinWHosService;
    @PostMapping("/addquote")
    public QuoteBeerInWrhouse NewQuate(@Valid @RequestBody QuoteBrInWHouseRequest request) throws Exception{

            return quoteBeerinWHosService.create(request);


    }

    @GetMapping("generateQuote/{id}")
    public List<QuoteBeerInWrhouse> GenerateQuot(@Valid @PathVariable("id") Long id) throws Exception{
            return quoteBeerinWHosService.findById(id);
            
    }
    
}