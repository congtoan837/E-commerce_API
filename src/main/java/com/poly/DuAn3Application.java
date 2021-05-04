package com.poly;

import com.poly.model.Payment;
import com.poly.model.Users;
import com.poly.repositories.PaymentRepository;
import com.poly.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DuAn3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DuAn3Application.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// Lưu vào db
		Payment payment = new Payment();
		payment.setName("COD");

		Users users = new Users();
		users.setName("ADMIN");
		users.setUsername("admin");
		users.setPassword("admin");
		users.setRole("ADMIN");
		if(userRepository.getByUser(users.getUsername()) == null) {
			userRepository.save(users);
			paymentRepository.save(payment);
		}
}}
