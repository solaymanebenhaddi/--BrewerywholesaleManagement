package com.brewery.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BeerInwhDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.BeerInWarehouse;
import com.brewery.manager.models.Warehouse;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.BeerinwhRequest;
import com.brewery.manager.repository.BeerInwareHouseRepository;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.WareHouseRepository;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;
@Transactional
@Service
public class BeerInWareHouseServices implements PublicDAO<BeerinwhRequest> {


    @Autowired
    private BeerInwareHouseRepository beerhouserepo;
    @Autowired
    private BeerRepository beerrepo;
    @Autowired
    private WholesaleRepository salerrepo;
    @Autowired
    private WareHouseRepository warerepo;
    @Autowired
    private BrewMapper mapper;

    @Override
    public BeerInwhDTO create(BeerinwhRequest o) throws Exception {

        try {
            Beer beer= beerrepo.findById(o.getId_beer()).orElseThrow(()->new ResourceNotFoundException("No Matching found"));
            Warehouse warehouse= warerepo.findById(o.getId_warehouse()).orElseThrow(()->new ResourceNotFoundException("No Matching found"));

        Optional<BeerInWarehouse> Isbeerinstock = beerhouserepo.getByIds(o.getId_beer(), o.getId_beer());
        if(Isbeerinstock.isPresent()){
            this.update(o);
        }else{
            
            BeerInWarehouse BeerStock=new BeerInWarehouse(beer,warehouse,o.getQuantity());
            beerhouserepo.save(BeerStock);

            return mapper.map(BeerStock, BeerInwhDTO.class);
            
        }
        return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    
    }

    @Override
    public BeerInwhDTO update(BeerinwhRequest o) throws Exception {

        try {

            BeerInWarehouse beerinstock = beerhouserepo.getByIds(o.getId_beer(), o.getId_warehouse()).orElseThrow(()->new ResourceNotFoundException("No Matching Found"));
        //check if the stock is emty or not
        Long existingStock=null;
        if(o.getQuantity()>0){
            existingStock = beerinstock.getExistingBeerQte()>0 ? beerinstock.getExistingBeerQte()+ o.getQuantity(): o.getQuantity();
        }else{
            existingStock = beerinstock.getExistingBeerQte()+ o.getQuantity()>=0 ? beerinstock.getExistingBeerQte()+ o.getQuantity() : -1;
        }
        
        if(existingStock!=-1){

            beerinstock.setExistingBeerQte(existingStock);
            beerhouserepo.save(beerinstock);
             return mapper.map(beerinstock, BeerInwhDTO.class);
        }
        else throw new ResourceNotFoundException("This beer is no more availible");
    
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        return null;
        
    }

    public ResponseEntity<?> DeletByIDs(BeerinwhRequest o) throws Exception{

        try {
            BeerInWarehouse beerinstock = beerhouserepo.getByIds(o.getId_beer(), o.getId_warehouse()).orElseThrow(()->new ResourceNotFoundException("No Matching Found"));
            beerhouserepo.delete(beerinstock);
            ResponseEntity.status(200).build();
            return ResponseEntity.ok(" deleted seccessefully"); 
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
       
    }

    @Override
    public List<?> findAll() throws Exception {
        try {
            List<BeerInWarehouse> beerInWarehouses=beerhouserepo.findAll();
            return beerInWarehouses;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override
    public BeerInwhDTO findById(long id) throws Exception {
       return null;

    }

    public BeerInwhDTO findOneByIDs(BeerinwhRequest o) throws Exception {
        try {
            BeerInWarehouse beerinstock = beerhouserepo.getByIds(o.getId_beer(), o.getId_warehouse()).orElseThrow(()->new ResourceNotFoundException("No Matching Found"));
            return mapper.map(beerinstock, BeerInwhDTO.class);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
 
     }
   
    
}
