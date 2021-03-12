package com.poly.controller;

import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.poly.ex.JwtUtils;
import com.poly.model.JwtResponse;
import com.poly.model.LoginRequest;
import com.poly.repositories.AdminRepository;
import com.poly.services.AdminService;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "localhost:8080")
@RestController
@RequestMapping("/")
public class AuthController {

	private static final Logger LOGGER = Logger.getLogger(Authentication.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			AdminService userDetails = (AdminService) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			return getResponseEntity(
					new JwtResponse(jwt, userDetails.getUsername(), roles),"1","Login success!", HttpStatus.OK);
		}catch (Exception e) {
			return getResponseEntity(null, "-1", "Login fail!", HttpStatus.BAD_REQUEST);
		}
	}
	
	private ResponseEntity<?> getResponseEntity(Object data, String code, String mess, HttpStatus status) {
		Map<String, Object> response = new HashMap<>();
		response.put("data",data);
		response.put("code",code);
		response.put("messenger",mess);
		return new ResponseEntity<>(response, status);
	}
}