package com.brewery.manager.models;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Beer_wholesaler")
@Data
public class StockBeerSaler {
    @EmbeddedId
    private BeerWholesaleIDs id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_beer")
    @JoinColumn(name = "id_beer", referencedColumnName = "id_beer")
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private Beer beer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_wholesale")
    @JoinColumn(name = "id_wholesale", referencedColumnName = "id_wholesale")
    private Wholesaler wholesaler;


    private Long quantity;

    public StockBeerSaler(){
       super(); 
    }

    public StockBeerSaler(Beer beer,Wholesaler wholesaler,long quantity){
        super(); 
        this.id =  new BeerWholesaleIDs(beer.getId_beer(),wholesaler.getId_wholesale());
        this.beer=beer;
        this.wholesaler=wholesaler;
        this.quantity=quantity;
     }

}
