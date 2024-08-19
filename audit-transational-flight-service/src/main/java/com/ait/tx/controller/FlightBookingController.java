package com.ait.tx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.tx.dto.FlightBookingAck;
import com.ait.tx.dto.FlightBookingRequest;
import com.ait.tx.service.FlightBookingService;

@RestController
@RequestMapping("/book")
public class FlightBookingController {
	
	@Autowired
	private FlightBookingService flightBookingService;
	
	@PostMapping("/v1/flightticket")
	public FlightBookingAck bookFlightTicket(@RequestBody FlightBookingRequest request){
		return flightBookingService.bookFlightTicket(request);
	}

}
