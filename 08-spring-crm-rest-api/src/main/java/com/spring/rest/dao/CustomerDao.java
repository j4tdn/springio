package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.entity.Customer;
import com.spring.rest.sorting.SortOrder;

public interface CustomerDao {
	List<Customer> getAll();
	
	List<Customer> search(String keyword);

	List<Customer> getAll(SortOrder sortOrder);
	
	List<Customer> getAll(SortOrder sortOrder, int offset, int recordsPerPage);
	
	int countTotalRecords();

	Customer get(int id);

	void save(Customer customer);

	void delete(int id);

	

	
}
