package com.brewery.manager.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.BrewerieDTO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
import com.brewery.manager.repository.BrewerieRepository;
import com.brewery.manager.util.BrewMapper;
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
    public BrewerieDTO create(BrewerieDTO o) {
        Brewerie brewerie=new Brewerie();
        brewerie.setAdresse(o.getAdresse());
        brewerie.setName(o.getName());
        brewrepo.save(brewerie);
        return mapper.map(brewerie, BrewerieDTO.class);
    }

    @Override
    public BrewerieDTO update(BrewerieDTO o) {
        return o;
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<BrewerieDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public BrewerieDTO findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    public Beer SellBeers(Long idBeer,Long quantity){


        return null;
        
    }

    
    
}
