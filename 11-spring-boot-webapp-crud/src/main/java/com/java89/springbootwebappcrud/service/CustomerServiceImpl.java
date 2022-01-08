package com.java89.springbootwebappcrud.service;

import com.java89.springbootwebappcrud.dao.CustomerDao;
import com.java89.springbootwebappcrud.dao.CustomerRepository;
import com.java89.springbootwebappcrud.entity.Customer;
import com.java89.springbootwebappcrud.sorting.SortOrder;
import com.java89.springbootwebappcrud.sorting.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao, CustomerRepository customerRepository) {
		this.customerDao = customerDao;
	}

	@Override
	@Transactional
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	@Override
	@Transactional
	public List<Customer> getAll(String orderBy, boolean isAsc) {
		return customerDao.getAll(getSortOrder(orderBy, isAsc));
	}

	@Override
	@Transactional
	public List<Customer> getAll(String sortProperty, boolean sortDirection, int offset, int recordsPerPage) {
		return customerDao.getAll(getSortOrder(sortProperty, sortDirection), offset, recordsPerPage);
	}


	@Override
	@Transactional
	public int countTotalRecords() {
		return customerDao.countTotalRecords();
	}

	@Override
	@Transactional
	public List<Customer> search(String keyword) {
		return customerDao.search(keyword);
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	@Transactional
	public Customer get(int id) {
		return customerDao.get(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}

	private SortOrder getSortOrder(String orderBy, boolean isAsc) {
		// default sort order: first_name
		SortOrder defaultSortOrder = new SortOrder().addParam(Customer.FIRST_NAME, isAsc);
		if (orderBy == null) {
			return defaultSortOrder;
		}

		String sortProperty = SortUtils.CUSTOMER_ORDER_MAP.get(orderBy);

		if (sortProperty == null) {
			return defaultSortOrder;
		}

		SortOrder sortOrder = new SortOrder().addParam(sortProperty, isAsc);

		if (sortProperty.equals(Customer.FIRST_NAME)) {
			sortOrder.addParam(Customer.LAST_NAME, true);
		} else if (sortProperty.equals(Customer.LAST_NAME)) {
			sortOrder.addParam(Customer.FIRST_NAME, true);
		}

		return sortOrder;
	}

}