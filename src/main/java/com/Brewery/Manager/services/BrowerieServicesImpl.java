package com.brewery.manager.services;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.models.Beer;
import com.brewery.manager.models.Brewerie;
@Transactional
@Service

public class BrowerieServicesImpl implements PublicDAO<Brewerie> {

    @Autowired
    private BeerServicesImpl beerservices;

    @Override
    public Brewerie create(Brewerie o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Brewerie o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Brewerie o) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Brewerie> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Brewerie> findById(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    
    
}
