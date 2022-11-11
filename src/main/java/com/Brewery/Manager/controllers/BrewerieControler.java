package com.brewery.manager.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brewery.manager.Dto.BeerDTO;
import com.brewery.manager.models.Beer;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/brewerie")
public class BrewerieControler {

    @GetMapping("/getAllbeers/{idbrew}")
    public List<Beer> BeersByBrewerie(@Valid @PathVariable("idbrew") Long idbrow){
        return null;
    }

    @PostMapping("addbeer")
    public Beer AddBeer(@RequestBody BeerDTO beer){

        
        return null;
        
    }
    
}
