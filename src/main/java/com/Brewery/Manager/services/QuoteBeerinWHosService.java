package com.brewery.manager.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brewery.manager.DAO.PublicDAO;
import com.brewery.manager.models.BeerInWarehouse;
import com.brewery.manager.models.QuateandBeersHouseIDs;
import com.brewery.manager.models.Quote;
import com.brewery.manager.models.QuoteBeerInWrhouse;
import com.brewery.manager.models.Warehouse;
import com.brewery.manager.models.Wholesaler;
import com.brewery.manager.payload.Response.QuoteResponse;
import com.brewery.manager.payload.request.QuoteBrInWHouseRequest;
import com.brewery.manager.repository.BeerInwareHouseRepository;
import com.brewery.manager.repository.QuoteBrInWhouseRespository;
import com.brewery.manager.repository.QuoteRepository;
import com.brewery.manager.repository.WareHouseRepository;
import com.brewery.manager.repository.WholesaleRepository;
import com.brewery.manager.util.ResourceNotFoundException;

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
        // find if this Quote has been created :
        Quote quote=quoteRepository.findById(o.getId_dev()).orElseThrow(()->new ResourceNotFoundException("NO matchig Quote found"));

       //find if this whole seller exist
        Wholesaler wholesaler= wholesaleRepository.findById(o.getId_wholesale()).orElseThrow(()-> new ResourceNotFoundException("No matching wholeseller Found ! "));

       // find if warehouse of this whole seller existe :
        Warehouse warehouse=wareHouseRepository.finbyidandWholeseller(o.getId_warehouse(),wholesaler.getId_wholesale()).orElseThrow(()->new ResourceNotFoundException("No matching warehouse Found !"));
        //find if beer is in warehouse :
        BeerInWarehouse beerhouse=beerInwareHouseRepository.getByIds(o.getId_beer(),warehouse.getId_warehouse()).orElseThrow(()-> new ResourceNotFoundException("No Beer matching exist in ths warehouse"));

        Optional <QuoteBeerInWrhouse> IsBeersHouse = quotbwrepo.isQuotehasBeer(quote.getId_devis(), beerhouse.getBeer().getId_beer());

        // find out if  the quantity above or equale what in asked in the request  :
         // retrive the object relatied to beer and warehouse :
         BeerInWarehouse qtBeerInWarehouse=null;
         if(IsBeersHouse.isEmpty()){
             if(o.getQuantity()>0){
                qtBeerInWarehouse=beerInwareHouseRepository.getByIdsandQte(beerhouse.getBeer().getId_beer(), beerhouse.getWarehouse().getId_warehouse(),o.getQuantity()).orElseThrow(()-> new ResourceNotFoundException("The number of beers ordered cannot be greater than the wholesaler's stock"));
             } else throw new ResourceNotFoundException("The order cannot be empty");    
         } else throw new ResourceNotFoundException("u cant double Orders");
                
        // check the discount to apply 
        double discount = o.getQuantity()>=20?0.2:(o.getQuantity()>=10?0.1:0);
        
       // Calculate the price with the discount applied :
        double price =(o.getQuantity()*beerhouse.getBeer().getPrice())-discount;

      //after conferm that all is OK we save this transaction :
      QuoteBeerInWrhouse devBeersHouse= new QuoteBeerInWrhouse(quote, qtBeerInWarehouse,o.getQuantity(),price,discount);

      quotbwrepo.save(devBeersHouse);

        return devBeersHouse;
    }

    @Override
    public Object update(QuoteBrInWHouseRequest o) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) throws Exception {
       return null;
        
    }

  
    public ResponseEntity<?> deleteQuoteBeer(QuoteBrInWHouseRequest o) throws Exception {
        try{
            QuoteBeerInWrhouse quoteBeerInWrhouse=quotbwrepo.isQuotehasBeer(o.getId_dev(),o.getId_beer()).orElseThrow(()->new ResourceNotFoundException("NO match found"));
            quotbwrepo.delete(quoteBeerInWrhouse);
            ResponseEntity.status(200).build();
            return ResponseEntity.ok("Quot of beer its been deleted seccessefully");
        }catch (Exception e) {
            throw new Exception(e.getMessage());
            }
        
    }

    @Override
    public List<?> findAll() throws Exception {
        try {
            return quotbwrepo.findAll();
        
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
       
    }

    @Override
    public List<QuoteBeerInWrhouse> findById(long id) throws Exception {
        try {
            List<QuoteBeerInWrhouse> qtbeerhouse=quotbwrepo.getAllQuoteByIdquote(id);
            return qtbeerhouse; 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }

    public ResponseEntity<QuoteResponse> GenerateQuate(long id_devis) throws Exception{
        
        try {

             // find if this Quote has been created :
        Quote quote=quoteRepository.findById(id_devis).orElseThrow(()->new ResourceNotFoundException("NO matchig Quote found"));


        QuoteResponse quoteResponse=new QuoteResponse();

        List<QuoteBeerInWrhouse> allquote = quotbwrepo.getQuoteBeerByQuoteID(quote.getId_devis());
        quoteResponse.setId_dev(quote.getId_devis());
        quoteResponse.setDay(quote.getDateqoute().getDayOfWeek());
        quoteResponse.setDatetransaction(quote.getDateqoute());
        quoteResponse.setQuoteBeerInWrhouses(// A list of all the beers in the warehouse.
        allquote);  

        return ResponseEntity.accepted().body(quoteResponse);

            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
           }
    
}
