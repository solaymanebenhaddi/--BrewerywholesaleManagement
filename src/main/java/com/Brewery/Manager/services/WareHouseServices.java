package com.brewery.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
        Wholesaler saler= salerrepo.findById(o.getId_wholesale()).orElseThrow(()->new Exception("No matching found"));
        Warehouse warehouse=new Warehouse();
        warehouse.setAdresse(o.getAdresse());
        warehouse.setWholesaler(saler);
        warerepo.save(warehouse);
        return mapper.map(warehouse, WareHouseDTO.class);

    }

    @Override
    public WareHouseDTO update(WarehouseRequest o) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<?> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WareHouseDTO findById(long id) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }
    
}
