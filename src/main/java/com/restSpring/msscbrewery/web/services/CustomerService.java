package com.restSpring.msscbrewery.web.services;

import java.util.UUID;

import com.restSpring.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
	
	CustomerDto getCustomerById(UUID custId);
	CustomerDto saveNewCustomer(CustomerDto custDto);
	void updateCustomer(UUID custId,CustomerDto custDto);
	void deleteCustomer(UUID custId);

}
