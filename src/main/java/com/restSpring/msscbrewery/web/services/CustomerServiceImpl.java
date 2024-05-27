package com.restSpring.msscbrewery.web.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.restSpring.msscbrewery.web.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID custId) {
		return CustomerDto.builder()
				.id(custId)
				.Name("Alex Parker")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto custDto) {
		custDto.setId(UUID.randomUUID());
		return custDto;
	}

	@Override
	public void updateCustomer(UUID custId, CustomerDto custDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(UUID custId) {
		// TODO Auto-generated method stub
		
	}

}
