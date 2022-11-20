package com.brewery.manager.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "QouteBeer")
@Data
public class QuoteBeerInWrhouse implements Serializable {
    

    @EmbeddedId
    private QuateandBeersHouseIDs QtBrHouseIDs;

    
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_devis")
    @JoinColumn(name = "id_devis", referencedColumnName = "id_devis")
    @JsonIgnore
    private Quote quote;

    @MapsId("id_Brwrhs")
    @JoinColumns({
        @JoinColumn(name="id_beer", referencedColumnName="id_beer"),
        @JoinColumn(name="id_warehouse", referencedColumnName="id_warehouse")
    })
    @ManyToOne
    @JsonIgnore
    private BeerInWarehouse bWarehouse;

    private long quantity;

    private Double discount;

    private Double price;
    public QuoteBeerInWrhouse(){
        super();
    }

    public QuoteBeerInWrhouse(Quote quote,BeerInWarehouse bWarehouse,long quantity,Double price,double discount){

        super();
        this.QtBrHouseIDs=new QuateandBeersHouseIDs(quote.id_devis, bWarehouse.getIdbw());
        this.bWarehouse=bWarehouse;
        this.quote=quote;
        this.quantity=quantity;
        this.price=price;
        this.discount=discount;
    }
}
