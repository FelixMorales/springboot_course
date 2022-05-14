package com.luv2code.springboot.demo.myapp.logic.services;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;
import com.luv2code.springboot.demo.myapp.logic.services.interfaces.IEmployeeService;
import com.luv2code.springboot.demo.myapp.persistence.springdatajpa.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeRepository _employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeDao) {
        _employeeRepository = employeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return _employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee find(long id) {
        Optional<Employee> result = _employeeRepository.findById( id );

        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }
        return employee;
    }

    @Override
    @Transactional
    public Employee add(Employee employee) {

        employee.setId( 0 );
        validateEmployeeExistByEmail( employee.getEmail() );

        return _employeeRepository.save( employee );
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {

        Employee currentEmployee = validateEmployeeExists(employee.getId());


        if (!employee.getEmail().equals(currentEmployee.getEmail())) {
            validateEmployeeExistByEmail(employee.getEmail());
        }

        return _employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee delete(long id) {
        Employee employee = validateEmployeeExists( id );
        _employeeRepository.delete( employee );
        return employee;
    }

    private void validateEmployeeExistByEmail(String email) {
        Employee employee = _employeeRepository.findOneByEmail(email);

        if (employee != null) {
            throw new RuntimeException(String.format("Employee with the email %s already exists", email));
        }
    }

    private Employee validateEmployeeExists(long id) {
        Optional<Employee> employee = _employeeRepository.findById( id );

        if (employee.isEmpty()) {
            throw new RuntimeException(String.format("Employee with Id %d doesn't exists", id));
        }

        return employee.get();
    }
}
