package com.java89.springbootwebappcrud.dao;

import com.java89.springbootwebappcrud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
