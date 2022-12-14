package com.brewery.manager.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BrewerieSalesDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.BrewerieSales;
import com.brewery.manager.models.Warehouse;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.BeerinwhRequest;
import com.brewery.manager.payload.request.BrewerieSaleRequest;
import com.brewery.manager.repository.BeerRepository;
import com.brewery.manager.repository.BrewerieSalesRepository;
import com.brewery.manager.repository.WareHouseRepository;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;

@Transactional
@Service
public class BrewerieSalesServices implements PublicDAO<BrewerieSaleRequest> {

    @Autowired
    BrewerieSalesRepository BrewSalesRep;
    @Autowired
    WholesaleRepository wholesalerep;

    @Autowired
    BeerRepository beerrepo;

    @Autowired
    BeerInWareHouseServices bHouseServices;
    
    @Autowired
    WareHouseRepository wareHouseRepository;

    @Autowired
    BrewMapper mapper;

    @Override
    public BrewerieSalesDTO create(BrewerieSaleRequest salereq) throws Exception {
try {
            Wholesaler wholesale = wholesalerep.findById(salereq.getId_wholesale())
                .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
        Beer beer = beerrepo.findById(salereq.getId_beer())
                .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
        Warehouse warehouse=wareHouseRepository.finbyidandWholeseller(salereq.getId_warehouse(),wholesale.getId_wholesale()).orElseThrow(()->new ResourceNotFoundException("No matching Warehouse exists"));

        System.out.println(" id beer req :"+salereq.getId_wholesale());

        Optional<BrewerieSales>  brewerieSales= BrewSalesRep.getBrewerieSalesByIds(beer.getId_beer(),wholesale.getId_wholesale());
        if(brewerieSales.isEmpty()){

            double transaction = beer.getPrice() * salereq.getQuantity();
            BrewerieSales Brwsale = new BrewerieSales(beer, wholesale, transaction, salereq.getQuantity(),LocalDate.now());
            BrewSalesRep.save(Brwsale);
            BeerinwhRequest reqBhouse = new BeerinwhRequest();
            reqBhouse.setId_beer(beer.getId_beer());
            reqBhouse.setId_warehouse(warehouse.getId_warehouse());
            reqBhouse.setQuantity(salereq.getQuantity());
            bHouseServices.create(reqBhouse);
            BrewerieSalesDTO Brsale = mapper.map(Brwsale, BrewerieSalesDTO.class);
            return Brsale;
        } else throw new ResourceNotFoundException("U cannot add this records");
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

    @Override
    public BrewerieSalesDTO update(BrewerieSaleRequest o) throws Exception {
        try {
            
            Wholesaler wholesale = wholesalerep.findById(o.getId_wholesale())
                    .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
            Beer beer = beerrepo.findById(o.getId_beer())
                    .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
    
           Optional<BrewerieSales> bresales= BrewSalesRep.getBrewerieSalesByIds(beer.getId_beer(), wholesale.getId_wholesale());
           if(bresales.isPresent()){
            BrewerieSales brewerieSales=bresales.get();
            
            brewerieSales.setDateofsale(o.getDateofsale());
            brewerieSales.setPrice_transaction(beer.getPrice()*o.getQuantity());
            BrewSalesRep.save(brewerieSales);
            return mapper.map(brewerieSales, BrewerieSalesDTO.class);
    
           }
            else throw new ResourceNotFoundException("No Matching found for this sale");
        
        } catch (Exception e) {
        throw new Exception(e.getMessage());
        }
    }

    public ResponseEntity<?> deleteSale(BrewerieSaleRequest o) throws Exception {
        try {
            Wholesaler wholesale = wholesalerep.findById(o.getId_wholesale())
            .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
            Beer beer = beerrepo.findById(o.getId_beer())
            .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));

   Optional<BrewerieSales> bresales= BrewSalesRep.getBrewerieSalesByIds(beer.getId_beer(), wholesale.getId_wholesale());
   if(bresales.isPresent()){
    BrewerieSales brewerieSales=bresales.get();
    
    brewerieSales.setDateofsale(o.getDateofsale());
    brewerieSales.setPrice_transaction(beer.getPrice()*o.getQuantity());
    BrewSalesRep.delete(brewerieSales);
    ResponseEntity.status(200).build();
    return ResponseEntity.ok("Quot of beer its been deleted seccessefully");

   }
    else throw new ResourceNotFoundException("No Matching found for this sale");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public List<BrewerieSalesDTO> findAll() throws Exception {
        
    try{
        List<BrewerieSales> brewerieSales=BrewSalesRep.findAll();
        return (List<BrewerieSalesDTO>) mapper.map(brewerieSales, BrewerieSalesDTO.class);
    } catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

    @Override
    public BrewerieSalesDTO findById(long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    public BrewerieSalesDTO findByIDs(BrewerieSaleRequest o) throws Exception {
        try {
            Wholesaler wholesale = wholesalerep.findById(o.getId_wholesale())
            .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
            Beer beer = beerrepo.findById(o.getId_beer())
            .orElseThrow(() -> new ResourceNotFoundException("Brewerie not whaole seller"));
            BrewerieSales bresales= BrewSalesRep.getBrewerieSalesByIds(beer.getId_beer(), wholesale.getId_wholesale()).orElseThrow(()->new ResourceNotFoundException("NO match found !"));

            return mapper.map(bresales, BrewerieSalesDTO.class);


        } catch (Exception e) {
            // TODO: handle exception
        }
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }


}