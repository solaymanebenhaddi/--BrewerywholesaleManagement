package com.brewery.manager.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.models.BeerInWarehouse;
import com.brewery.manager.models.QuateandBeersHouseIDs;
import com.brewery.manager.models.Quote;
import com.brewery.manager.models.QuoteBeerInWrhouse;
import com.brewery.manager.models.Warehouse;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.request.QuoteBrInWHouseRequest;
import com.brewery.manager.repository.BeerInwareHouseRepository;
import com.brewery.manager.repository.QuoteBrInWhouseRespository;
import com.brewery.manager.repository.QuoteRepository;
import com.brewery.manager.repository.WareHouseRepository;
import com.brewery.manager.repository.WholesaleRepository;

// A keyword that is used to declare a class.

@Transactional
@Service
public class QuoteBeerinWHosService implements PublicDAO<QuoteBrInWHouseRequest> {

    @Autowired
    private BeerInwareHouseRepository beerInwareHouseRepository;

    @Autowired
    private WholesaleRepository wholesaleRepository;

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired QuoteRepository quoteRepository;

    @Autowired 
    private QuoteBrInWhouseRespository quotbwrepo;

    @Override
    public QuoteBeerInWrhouse create(QuoteBrInWHouseRequest o) throws Exception {



       //find if this whole seller exist
        Wholesaler wholesaler= wholesaleRepository.findById(o.getId_wholesale()).orElseThrow(()-> new Exception("No matching wholeseller Found ! "));

       // find if warehouse of this whole seller existe :
        Warehouse warehouse=wareHouseRepository.finbyidandWholeseller(o.getId_warehouse(),wholesaler.getId_wholesale()).orElseThrow(()->new Exception("No matching warehouse Found !"));
        //find if beer is in warehouse :
        BeerInWarehouse beerhouse=beerInwareHouseRepository.getByIds(o.getId_beer(),warehouse.getId_warehouse()).orElseThrow(()-> new Exception("No Beer matching exist in ths warehouse"));

        // find out if  the quantity above or equale what in asked in the request  :
         // retrive the object relatied to beer and warehouse :
         BeerInWarehouse qtBeerInWarehouse=null;
         if(o.getQuantity()>0){
            qtBeerInWarehouse=beerInwareHouseRepository.getByIdsandQte(beerhouse.getBeer().getId_beer(), beerhouse.getWarehouse().getId_warehouse(),o.getQuantity()).orElseThrow(()-> new Exception("The number of beers ordered cannot be greater than the wholesaler's stock"));
         } else throw new Exception("The order cannot be empty");    
                
        // check the discount to apply 
        double discount = o.getQuantity()>=20?0.2:(o.getQuantity()>=10?0.1:0);
        
       // Calculate the price with the discount applied :
        double price =(o.getQuantity()*beerhouse.getBeer().getPrice())-discount;

      // Create the new Quote astance in current date :

      Quote NewDevis=new Quote();
      NewDevis.setDateqoute(LocalDate.now());
      quoteRepository.save(NewDevis);

      //after conferm that all is OK we save this transaction :
      QuoteBeerInWrhouse devBeersHouse= new QuoteBeerInWrhouse(NewDevis, qtBeerInWarehouse,o.getQuantity(),price,discount);

      quotbwrepo.save(devBeersHouse);

        return devBeersHouse;
    }

    @Override
    public Object update(QuoteBrInWHouseRequest o) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<?> findAll() {
       
        return quotbwrepo.findAll();
    }

    @Override
    public List<QuoteBeerInWrhouse> findById(long id) throws Exception {
        
        return quotbwrepo.getQuoteBeerByQuoteID(id);
    }
    
}
