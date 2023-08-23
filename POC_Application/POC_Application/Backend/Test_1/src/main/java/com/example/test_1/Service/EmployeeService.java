package com.example.test_1.Service;

import java.util.List;
import java.util.Optional;

import com.example.test_1.DTO.Employeedto;
import com.example.test_1.Entity.Employee;

public interface EmployeeService {
	
	//save new Employee
	Employee saveEmployee(Employeedto employeeDto);
	//Update Employee
	Employee updateEmployee(Employee employee);
	//delete Employee
	String deleteEmployee(int id);
	//get Employee by ID
	Optional<Employee> getEmployeebyId(int id);
	//List All the employee
	List<Employee> listAllEmployee();
	
}
