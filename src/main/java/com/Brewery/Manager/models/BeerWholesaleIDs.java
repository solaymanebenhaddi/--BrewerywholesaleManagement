package com.brewery.manager.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class BeerWholesaleIDs implements Serializable {
    

    @Column(name = "id_beer")
    private Long id_beer;

    @Column(name = "id_wholesale")
    private Long id_wholesale;

    
    public BeerWholesaleIDs(){
        super();
    }

    public BeerWholesaleIDs(long beer_id,Long wholesale_id){
       super();
       this.id_beer=beer_id;
       this.id_wholesale=wholesale_id;
    }
}
