package com.brewery.manager.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Embeddable
@Data
public class QuateandBeersHouseIDs {
    

    @Column(name = "id_devis")
    private Long id_devis;

    @OneToOne(optional = false) 
    @JoinColumn(name = "id", nullable = false) 
    private BeerInWarehouse bInWarehouse;
    
    public QuateandBeersHouseIDs(){
        super();
    }

    public QuateandBeersHouseIDs(long iddev,BeerInWarehouse bInWarehouse){
        super();
        this.id_devis=iddev;
        this.bInWarehouse=bInWarehouse;
    }
}
