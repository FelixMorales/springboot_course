package com.luv2code.springboot.demo.myapp.persistence.springdatajpa.repository;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findOneByEmail(String email);
}
