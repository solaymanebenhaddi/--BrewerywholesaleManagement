package com.brewery.manager.payload.Response;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.brewery.manager.models.Beer;
import com.brewery.manager.models.QuoteBeerInWrhouse;

import lombok.Data;

@Data
public class QuoteResponse {

    DayOfWeek day;

	LocalDate datetransaction;

    private Long id_dev;

    private List<QuoteBeerInWrhouse> quoteBeerInWrhouses;
	
	public QuoteResponse(Long id_dev,DayOfWeek day, List<QuoteBeerInWrhouse> quoteBeerInWrhouses,LocalDate datetransaction) {
		this.day = day;
		this.datetransaction = datetransaction;
		this.quoteBeerInWrhouses=quoteBeerInWrhouses;
        this.id_dev=id_dev;
	}

	public QuoteResponse() {
	}

    
}
