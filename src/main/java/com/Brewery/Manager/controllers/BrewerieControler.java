package com.brewery.manager.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.manager.Dto.BeerDTO;
import com.brewery.manager.Dto.BrewerieDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.services.BeerServicesImpl;
import com.brewery.manager.services.BrowerieServicesImpl;
import com.brewery.manager.util.BrewMapper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/brewerie")
public class BrewerieControler {

    @Autowired
    private BrowerieServicesImpl brewservices;

    @Autowired
    private BeerServicesImpl beerservices;

    @Autowired
    private BrewMapper mapper;

    @GetMapping("/getAllbeers/{idbrew}")
    public List<BeerDTO> BeersByBrewerie(@Valid @PathVariable("idbrew") Long idbrow) throws Exception{

        return beerservices.BeerbyIdBrewerie(idbrow).stream()
        .map(beer->mapper.map(beer, BeerDTO.class)).collect(Collectors.toList());

        
    }

    @PostMapping("/addbeer")
    public BeerDTO AddBeer(@RequestBody BeerDTO beer) throws Exception{
        beerservices.create(beer);
        return mapper.map(beer, BeerDTO.class);
   
    }

    @PostMapping("/addbrewerie")
    public BrewerieDTO addbrewerie(@RequestBody BrewerieDTO brewerieDTO) throws Exception{
        BrewerieDTO brew=brewservices.create(brewerieDTO);
        return brew;
   
    }
    
}
