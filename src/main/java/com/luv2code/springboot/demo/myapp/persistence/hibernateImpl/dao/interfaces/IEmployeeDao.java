package com.luv2code.springboot.demo.myapp.persistence.hibernateImpl.dao.interfaces;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;

public interface IEmployeeDao extends IBaseDao<Employee> {

    Employee findByEmail(String email);
}
