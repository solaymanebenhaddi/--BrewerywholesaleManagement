package com.brewery.manager.Dto;

import java.util.List;



import lombok.Data;

@Data
public class BrewerieDTO {

    private long id_brewerie;
    private String Name;
    private String Adresse;
    private List<BeerDTO> beers;
    
}
