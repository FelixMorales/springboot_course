package com.luv2code.springboot.demo.myapp.rest;

import com.luv2code.springboot.demo.myapp.common.entities.Employee;
import com.luv2code.springboot.demo.myapp.logic.services.interfaces.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private IEmployeeService _employeeService;

    @Autowired
    public EmployeeRestController(IEmployeeService employeeService) {
        _employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> findAll() {
        return _employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee find(@PathVariable long employeeId) {
        return _employeeService.find( employeeId );
    }

    @PostMapping("")
    public Employee add(@RequestBody Employee employee) {
        employee.setId(0);
        return _employeeService.add( employee );
    }

    @PutMapping("/{employeeId}")
    public Employee update(@RequestBody Employee employee, @PathVariable long employeeId) {
        employee.setId( employeeId );
        return  _employeeService.update( employee );
    }

    @DeleteMapping("/{employeeId}")
    public Employee delete(@PathVariable long employeeId) {
        return _employeeService.delete( employeeId );
    }
}
