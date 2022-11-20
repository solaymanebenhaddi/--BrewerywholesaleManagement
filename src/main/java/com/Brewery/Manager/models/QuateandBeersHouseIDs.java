package com.brewery.manager.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Embeddable
@Data
public class QuateandBeersHouseIDs implements Serializable {
    

    @Column(name = "id_devis")
    private Long id_devis;

    @Column(name = "id_Brwrhs")
    private BeerInWarehouseIDs id_Brwrhs;
    
    public QuateandBeersHouseIDs(){
        super();
    }

    public QuateandBeersHouseIDs(long iddev,BeerInWarehouseIDs bInWarehouse){
        super();
        this.id_devis=iddev;
        this.id_Brwrhs=bInWarehouse;
    }
}
