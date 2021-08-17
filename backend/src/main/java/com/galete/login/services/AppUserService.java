package com.galete.login.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.galete.login.entities.AppUser;
import com.galete.login.entities.ConfirmationToken;
import com.galete.login.repositories.AppUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{

	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	
	private final AppUserRepository repository;
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private final ConfirmationTokenService tokenService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}
	
	@Transactional	
	public String signUpUser(AppUser appUser) {
		
		boolean userExists = repository
								.findByEmail(appUser.getEmail())
								.isPresent();
		
		if(userExists) {
			throw new IllegalStateException("Email already taken!");
		}
		
		appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
		
		repository.save(appUser);
		
		String token = UUID.randomUUID().toString();
		
		ConfirmationToken confirmationToken = new ConfirmationToken(
													token, 
													LocalDateTime.now(),
													LocalDateTime.now().plusMinutes(15),
													appUser);
		
		tokenService.saveConfirmationToken(confirmationToken);
		
		return token;
	}
	
	@Transactional
	public void enableAppUser(String email) {
		
		AppUser appUser = repository.findByEmail(email)
							.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
		
		appUser.setEnabled(true);
		
		repository.save(appUser);
	}
}
