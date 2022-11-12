package com.brewery.manager.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.Dto.WholeSalerDTO;
import com.brewery.manager.models.Wholesaler;


@Service
@Transactional
public class wholesalerImpl implements PublicDAO<WholeSalerDTO> {

    @Override
    public WholeSalerDTO create(WholeSalerDTO o) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WholeSalerDTO update(WholeSalerDTO o) {
        return o;
        // TODO Auto-generated method stub
        
    }


    @Override
    public List<WholeSalerDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public WholeSalerDTO findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
