package com.brewery.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.WareHouseDTO;
import com.brewery.manager.models.Warehouse;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.WarehouseRequest;
import com.brewery.manager.repository.WareHouseRepository;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;
@Transactional
@Service
public class WareHouseServices implements PublicDAO<WarehouseRequest> {

@Autowired
private WareHouseRepository warerepo;
@Autowired
private BrewMapper mapper;
@Autowired
private WholesaleRepository salerrepo;

    @Override
    public WareHouseDTO create(WarehouseRequest o) throws Exception {
        Wholesaler saler= salerrepo.findById(o.getId_wholesale()).orElseThrow(()->new ResourceNotFoundException("No matching found"));
        Warehouse warehouse=new Warehouse();
        warehouse.setAdresse(o.getAdresse());
        warehouse.setWholesaler(saler);
        warerepo.save(warehouse);
        return mapper.map(warehouse, WareHouseDTO.class);

    }

    @Override
    public WareHouseDTO update(WarehouseRequest o) throws Exception {
        try{
            Warehouse ware= warerepo.findById(o.getId_warehouse()).orElseThrow(()->new ResourceNotFoundException("No matching found"));
            Wholesaler saler= salerrepo.findById(o.getId_wholesale()).orElseThrow(()->new ResourceNotFoundException("No matching found"));
        ware.setAdresse(o.getAdresse());
        ware.setWholesaler(saler);
        warerepo.save(ware);
        return mapper.map(ware, WareHouseDTO.class);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
            }
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        try{
            Wholesaler saler= salerrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No matching found"));
            salerrepo.delete(saler);
            ResponseEntity.status(200).build();
            return ResponseEntity.ok("Deleted Seccessefully");

        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
            }
        
    }

    @Override
    public List<?> findAll() throws Exception {
    try{
        return warerepo.findAll();
    }catch (Exception e) {
        throw new Exception(e.getMessage());
        }
    
    }
    @Override
    public WareHouseDTO findById(long id) throws Exception {
   
        try{
            Warehouse ware= warerepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No matching found"));
            return mapper.map(ware, WareHouseDTO.class);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
            }
    }
    
}
