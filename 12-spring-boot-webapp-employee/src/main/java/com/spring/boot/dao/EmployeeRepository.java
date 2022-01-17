package com.spring.boot.dao;

import com.spring.boot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add a method to sort by last name
    // spring boot with find by some default pattern
    // https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    public List<Employee> findAllByOrderByLastNameAsc();

}
