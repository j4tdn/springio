package com.spring.service;

import java.util.List;

import com.spring.model.Customer;
import com.spring.rest.pagination.Pageable;

public interface CustomerRestClient {

	List<Customer> getAll();

	Pageable<Customer> getAll(String sort, int page);
	
	List<Customer> search(String keyword);

	Customer get(int customerId);

	void save(Customer theCustomer);

	void delete(int customerId);

	

	

}
