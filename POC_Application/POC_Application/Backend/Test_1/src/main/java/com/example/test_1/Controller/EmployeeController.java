package com.example.test_1.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.test_1.DTO.Employeedto;
import com.example.test_1.Entity.Employee;
import com.example.test_1.Exception.EmployeeNotFoundException;
import com.example.test_1.Service.EmployeeService;

@RestController
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    EmployeeService service;

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody @Valid Employeedto employeeDto) {
//    	employee.setCreatedDate(employee.getCreatedDate());
    	// logger.info("Inserting employee: {}", employee);
        // Employee savedEmployee = service.saveEmployee(employee);
        // logger.info("Employee inserted successfully: {}", savedEmployee);
        // return service.saveEmployee(employee);

        logger.info("Inserting employee: {}", employeeDto);
        Employee savedEmployee = service.saveEmployee(employeeDto);
        logger.info("Employee inserted successfully: {}", savedEmployee);
        return savedEmployee;
    }

    @PostMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        int employeeId = employee.getId();
        logger.info("Updating employee with ID: {}", employeeId);
        Optional<Employee> existingEmployeeOpt = service.getEmployeebyId(employeeId);
        if (existingEmployeeOpt.isPresent()) {
            Employee existingEmployee = existingEmployeeOpt.get();
            employee.setCreatedDate(existingEmployee.getCreatedDate());
            employee.setLastModifiedDate(existingEmployee.getLastModifiedDate());
            Employee updatedEmployee = service.updateEmployee(employee);
            logger.info("Employee updated successfully: {}", updatedEmployee);
            return updatedEmployee;
        } else {
            logger.error("Employee not found with ID: {}", employeeId);
            throw new EmployeeNotFoundException("Employee not found with ID: " + employeeId);
        }
    }

    @GetMapping("/getEmployeeById/{id}")
    public Optional<Employee> getEmployeebyId(@PathVariable int id) {
    	logger.info("Getting employee by ID: {}", id);
        Optional<Employee> employee = service.getEmployeebyId(id);
        logger.info("Employee retrieved successfully: {}", employee);
        this.applicationLogger();
        return service.getEmployeebyId(id);
    }

    @GetMapping("/listAllEmployee")
    public List<Employee> listAllEmployee() {
    	logger.info("Listing all employees");
        List<Employee> employees = service.listAllEmployee();
        logger.info("Total employees: {}", employees.size());
        return service.listAllEmployee();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
//    	logger.info("Deleting employee with ID: {}", id);
//        String result = service.deleteEmployee(id);
//        logger.info("Employee deleted successfully with ID: "+result);
        return service.deleteEmployee(id);
    }

    public void applicationLogger() {
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.error("This is an error message");
    }
}
