package com.zibble.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.zibble.entity.UserDetailsUD;
import com.zibble.impl.service.OtpService;
import com.zibble.impl.service.UserService;


@RestController
@RequestMapping("/login")
public class OtpControl {
	
	@Autowired
    private OtpService service;
	
	@Autowired
	private UserService userService;


	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@PostMapping("generateOtp")
    public Map<String, String> getSessionId(@RequestParam("number") String number)
    {
		ResponseEntity<JsonNode> otpResponse= this.service.otpService(restTemplate(new RestTemplateBuilder()), number);
		JsonNode node = otpResponse.getBody();
		//String sessionId = StringUtils.chop(node.get("Details").toString().substring(1));
		String sessionId = node.get("Details").toString().replace("\"", "");
		
		//String arpan = "My name is \"Arpan\"";  // to print "My name is "Arpan"
		
        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId );

        return response;
    }	
	
	@PostMapping("verifyOtp")
    public Map<String, String> verifyOtp(@RequestParam("number") String mobileNumberUD, @RequestParam("otp") String otp, @RequestParam("sessionId") String sessionId)
    {
		ResponseEntity<JsonNode> otpVerify= this.service.verifyOtp(restTemplate(new RestTemplateBuilder()), otp, sessionId);
		JsonNode node = otpVerify.getBody();
		String otpStatus = node.get("Details").toString().replace("\"", "");
		
		//System.out.println(otpStatus);
		
		String otpStatusVerify = "OTP Matched";
		String entry = "Error: Query didnt't run";
		
		// check the database if user already exists
        UserDetailsUD existing = userService.findByMobileNumberUD(mobileNumberUD);
		System.out.println("User found in database " + existing);
        
				
		if(otpStatus.equals(otpStatusVerify)) {	
			if(existing == null) {
				 // create user account        						
		        userService.save(mobileNumberUD);
		        entry = "New User, entry made in database";
		        System.out.println("New user successfully added in database for number " + mobileNumberUD);
			}
			
			else {
			entry = "Existing User, no entry made in database";
			System.out.println("Existing user, no new user added in database");
			}
		}
     	
        Map<String, String> response = new HashMap<>();
        response.put("entry", otpStatus + " for " + mobileNumberUD + " and " + entry);

        return response;
    }	

	
}
