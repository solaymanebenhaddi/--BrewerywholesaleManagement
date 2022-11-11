package com.brewery.manager.DAO;

import java.util.List;
import java.util.Optional;

public interface PublicDAO<SDTO> {
	
        public SDTO create(SDTO o) throws Exception;
        public void update(SDTO o);
        public void delete(SDTO o);
        public List<SDTO> findAll();
        public Optional<SDTO> findById(long id);
    
        
    }