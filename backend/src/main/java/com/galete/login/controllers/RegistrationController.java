package com.galete.login.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.galete.login.requests.RegistrationRequest;
import com.galete.login.services.RegistrationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

	private final RegistrationService service;
	
	@PostMapping
	public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
		return ResponseEntity.ok(service.register(request));
	}
	
	@GetMapping(path = "/confirm")
	public String confirm(@RequestParam("token") String token) {
		return service.confirmToken(token);
	}
}
