package com.amigoscode.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepo customerRepo) {
	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder()
				.firstName(request.firstName())
				.lastName(request.lastName())
				.email(request.email())
				.build();
		// todo: check if email valid
		// todo: check if email not taken
		customerRepo.save(customer);
	}
}
