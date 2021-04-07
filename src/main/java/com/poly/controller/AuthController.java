package com.poly.controller;

import com.poly.model.Cart;
import com.poly.repositories.CartRepository;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
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
import com.poly.services.UserService;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

    private static final Logger LOGGER = Logger.getLogger(Authentication.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CartRepository cartRepository;

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
            UserService userDetails = (UserService) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            Cart c = cartRepository.getCartByCustomerId(userDetails.getId());
            if (c == null) {
                cartRepository.insert(userDetails.getId());
                Cart d = cartRepository.getCartByCustomerId(userDetails.getId());
                return getResponseEntity(new JwtResponse(jwt, d.getId(), userDetails.getId(), userDetails.getUsername(), roles), "1", "Login success!", HttpStatus.OK);
            } else {
                return getResponseEntity(new JwtResponse(jwt, c.getId(), userDetails.getId(), userDetails.getUsername(), roles), "1", "Login success!", HttpStatus.OK);
            }
        } catch (Exception e) {
            return getResponseEntity(null, "-1", "Login fail!", HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity<?> getResponseEntity(Object data, String code, String mess, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("code", code);
        response.put("messenger", mess);
        return new ResponseEntity<>(response, status);
    }
}