package com.luv2code.springboot.demo.myapp.logic.services.interfaces;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee find(long id);

    Employee add(Employee employee);

    Employee update(Employee employee);

    Employee delete(long id);

}
