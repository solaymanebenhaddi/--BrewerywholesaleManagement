package com.brewery.manager.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BrewerieDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
import com.brewery.manager.repository.BrewerieRepository;
import com.brewery.manager.util.BrewMapper;
import com.brewery.manager.util.ResourceNotFoundException;
@Transactional
@Service

public class BrowerieServicesImpl implements PublicDAO<BrewerieDTO> {

    @Autowired
    private BeerServicesImpl beerservices;

    @Autowired
    private BrewerieRepository brewrepo;

    @Autowired
    private BrewMapper mapper;

    @Override
    public BrewerieDTO create(BrewerieDTO o) throws Exception {
        try {
            Brewerie brewerie=new Brewerie();
        brewerie.setAdresse(o.getAdresse());
        brewerie.setName(o.getName());
        brewrepo.save(brewerie);
        return mapper.map(brewerie, BrewerieDTO.class);
    
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
        }

    @Override
    public BrewerieDTO update(BrewerieDTO o) throws Exception {
        try {
        Brewerie brewerie=brewrepo.findById(o.getId_brewerie()).orElseThrow(()->new ResourceNotFoundException("NO matching found"));
        brewerie.setAdresse(o.getAdresse());
        brewerie.setName(o.getName());
        brewrepo.save(brewerie);
        return mapper.map(brewerie, BrewerieDTO.class);
    
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
        
    }


    @Override
    public List<Brewerie> findAll() throws Exception {
    
    try{
        List<Brewerie> breweries=brewrepo.findAll();
        return breweries;
    } catch (Exception e) {
        throw new Exception(e.getMessage());
     }
    }

    @Override
    public BrewerieDTO findById(long id) throws Exception {
        try{
            Brewerie breweries=brewrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("NO matching found"));
            return mapper.map(breweries, BrewerieDTO.class);
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
         }
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
        try {
            Brewerie breweries=brewrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("NO matching found"));
            brewrepo.delete(breweries);
            ResponseEntity.status(200).build();
            return ResponseEntity.ok(" beer has been deleted seccessefully"); 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }


    
    
}
