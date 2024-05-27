package com.restSpring.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restSpring.msscbrewery.web.model.CustomerDto;
import com.restSpring.msscbrewery.web.services.CustomerService;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity handlePost(@RequestBody CustomerDto custDto)
	{
		CustomerDto savedCust = customerService.saveNewCustomer(custDto);
		HttpHeaders header = new HttpHeaders();
		header.add("Location", "/api/v1/customer"+savedCust.getId().toString());
		return new ResponseEntity(header,HttpStatus.NO_CONTENT);
	}
	
	@PutMapping({"/custId"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void handleUpdate(@PathVariable("custId") UUID custId, @RequestBody CustomerDto custDto){
		
		customerService.updateCustomer(custId, custDto);
	}
	
	@DeleteMapping({"/custId"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("custId") UUID beerId){
		customerService.deleteCustomer(beerId);
	}
}
