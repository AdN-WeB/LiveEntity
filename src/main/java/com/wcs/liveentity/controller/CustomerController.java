package com.wcs.liveentity.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wcs.liveentity.dto.CustomerDto;
import com.wcs.liveentity.model.Customer;
import com.wcs.liveentity.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	
	// get all
	@GetMapping
	public List<Customer> getAll(){
		return customerRepository.findAll();
	}
	
	// Create
	@PostMapping
	public Customer create(@Valid @RequestBody CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setAddress(customerDto.getAddress());
		customer.setBirthdate(customerDto.getBirthdate());
		customer.setEmail(customerDto.getEmail());
		customer.setFirstname(customerDto.getFirstname());
		customer.setLastname(customerDto.getLastname());
		customer.setPassword(customerDto.getPassword());
		customer.setPhone(customerDto.getPhone());
		
		return customerRepository.save(customer);
	}
	
	// get one
	@GetMapping("/{id}")
	public Customer get(@PathVariable(required = true) Long id) {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if(optCustomer.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return optCustomer.get();
	}
	
	// update 
	@PutMapping("/{id}")
	public Customer update(@PathVariable(required = true) Long id, @Valid @RequestBody CustomerDto customerDto) {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if(optCustomer.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Customer customer = optCustomer.get();
		customer.setAddress(customerDto.getAddress());
		customer.setBirthdate(customerDto.getBirthdate());
		customer.setEmail(customerDto.getEmail());
		customer.setFirstname(customerDto.getFirstname());
		customer.setLastname(customerDto.getLastname());
		customer.setPassword(customerDto.getPassword());
		customer.setPhone(customerDto.getPhone());
		return customerRepository.save(customer);
	}
	
	// delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) Long id) {
		Optional<Customer> optCustomer = customerRepository.findById(id);
		if(optCustomer.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		customerRepository.deleteById(id);
	}
}
