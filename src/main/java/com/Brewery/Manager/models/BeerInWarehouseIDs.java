package com.brewery.manager.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class BeerInWarehouseIDs implements Serializable {
    

    @Column(name = "id_beer")
    private Long id_beer;

    @Column(name = "id_wholesale")
    private Long id_warehouse;

    
    public BeerInWarehouseIDs(){
        super();
    }

    public BeerInWarehouseIDs(long beer_id,Long id_warehouse){
       super();
       this.id_beer=beer_id;
       this.id_warehouse=id_warehouse;
    }
}
