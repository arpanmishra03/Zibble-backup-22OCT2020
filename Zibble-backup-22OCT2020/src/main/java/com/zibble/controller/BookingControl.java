package com.zibble.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zibble.impl.service.BookingService;


@Controller
public class BookingControl {
	
	
	@Autowired
	private BookingService bookingService;

	
	@PostMapping("/booking/make-booking")
    public Map<String, String> makeBooking(@RequestParam("number") String number, 
    		@RequestParam("idsv") String idsv, @RequestParam("idst") String idst, 
    		@RequestParam("idsc") String idsc)
    {
		
		bookingService.save(number, idsv, idst, idsc);
		
        Map<String, String> response = new HashMap<>();
       response.put("bookingStatus", "Status");
        //System.out.println(response);
        return response;
    }	 
	

}
