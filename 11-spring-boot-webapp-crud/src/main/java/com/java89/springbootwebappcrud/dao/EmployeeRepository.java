package com.java89.springbootwebappcrud.dao;

import com.java89.springbootwebappcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * No need @Repository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
