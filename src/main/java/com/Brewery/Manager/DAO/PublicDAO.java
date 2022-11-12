package com.brewery.manager.DAO;

import java.util.List;


public interface PublicDAO<SDTO> {
	
        public SDTO create(SDTO o) throws Exception;
        public SDTO update(SDTO o) throws Exception;
        public void delete(Long id) throws Exception;
        public List<SDTO> findAll();
        public SDTO findById(long id) throws Exception;
    
        
    }