package com.java89.springbootwebappcrud.dao;

import com.java89.springbootwebappcrud.entity.Customer;
import com.java89.springbootwebappcrud.sorting.SortOrder;

import java.util.List;


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
