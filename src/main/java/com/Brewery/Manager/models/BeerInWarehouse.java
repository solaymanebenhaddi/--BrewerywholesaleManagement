package com.brewery.manager.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BeerInWarehouse")
@Data
public class BeerInWarehouse implements Serializable {

    @EmbeddedId
    private BeerInWarehouseIDs idbw;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_beer")
    @JoinColumn(name = "id_beer", referencedColumnName = "id_beer")
    // @OnDelete(action = OnDeleteAction.CASCADE)
    private Beer beer;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @MapsId("id_warehouse")
    @JoinColumn(name = "id_warehouse", referencedColumnName = "id_warehouse")
    private Warehouse warehouse;

    private Long ExistingBeerQte;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="bWarehouse")
    public List<QuoteBeerInWrhouse> quoteBeerInWrhouses;



    public BeerInWarehouse(){
        super(); 
     }
 
     public BeerInWarehouse(Beer beer,Warehouse warehouse,long quantity){
         super(); 
         this.idbw =  new BeerInWarehouseIDs(beer.getId_beer(),warehouse.getId_warehouse());
         this.beer=beer;
         this.warehouse=warehouse;
         this.ExistingBeerQte=quantity;
      }

    
}
