package com.galete.login.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galete.login.entities.ConfirmationToken;
import com.galete.login.repositories.ConfirmationTokenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
	
	private final ConfirmationTokenRepository repository;
	
	@Transactional
	public void saveConfirmationToken(ConfirmationToken token) {
		repository.save(token);
	}
	
	@Transactional(readOnly = true)
	public Optional<ConfirmationToken> getToken(String token) {
		
		return repository.findByToken(token);
	}
}
