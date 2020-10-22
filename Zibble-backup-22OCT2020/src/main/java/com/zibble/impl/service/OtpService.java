package com.zibble.impl.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

public interface OtpService {

	ResponseEntity<JsonNode> otpService(RestTemplate restTemplate, String number);
	
	ResponseEntity<JsonNode> verifyOtp(RestTemplate restTemplate, String otp, String sessionId);

}