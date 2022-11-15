package com.brewery.manager.DAO;

import java.util.List;

import com.brewery.manager.Dto.WholeSalerDTO;


public interface PublicDAO<SRequest> {
	
        public Object create(SRequest o) throws Exception;
        public Object update(SRequest o) throws Exception;
        public void delete(Long id) throws Exception;
        public List<?> findAll();
        public Object findById(long id) throws Exception;
    
        
    }