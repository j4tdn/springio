package com.java89.springbootwebappcrud.dao;

import com.java89.springbootwebappcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * No need @Repository
 */
@RepositoryRestResource(path = "users")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

