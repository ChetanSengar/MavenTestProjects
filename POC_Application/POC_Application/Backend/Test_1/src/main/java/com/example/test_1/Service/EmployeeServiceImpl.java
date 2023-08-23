package com.example.test_1.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.test_1.Controller.EmployeeController;
import com.example.test_1.DTO.Employeedto;
import com.example.test_1.Entity.Employee;
import com.example.test_1.Exception.EmployeeNotFoundException;
import com.example.test_1.Repository.EmployeeRepo;
import io.micrometer.core.instrument.MeterRegistry;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private MeterRegistry registry;

	
	@Override
	public Employee saveEmployee(Employeedto employeeDto) {
		try {
			Employee employee = new Employee();
			employee.setFirst_name(employeeDto.getFirst_name());
			employee.setLast_name(employeeDto.getLast_name());
			employee.setEmail(employeeDto.getEmail());
			employee.setPhone_number(employeeDto.getPhone_number());
			employee.setJob_title(employeeDto.getJob_title());
			employee.setDepartment(employeeDto.getDepartment());
	        return repo.save(employee);
	    } catch (Exception e) {
	        registry.counter("service.employee.save.error").increment();
	        logger.error("Getting error while saving data in relation.", e);
	        throw e;
	    }
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		try {
	        Employee existingEmployee = repo.findById(employee.getId()).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: "+employee.getId()));
	        existingEmployee.setFirst_name(employee.getFirst_name());
	        existingEmployee.setLast_name(employee.getLast_name());
	        existingEmployee.setEmail(employee.getEmail());
	        existingEmployee.setJob_title(employee.getJob_title());
	        existingEmployee.setDepartment(employee.getDepartment());
	        existingEmployee.setPhone_number(employee.getPhone_number());
	        return repo.save(employee);
	    } catch (Exception e) {
	        registry.counter("service.employee.update.error").increment();
	        logger.error("Getting error while updating the employee.", e);
	        throw e;
	    }
	}

	@Override
	public String deleteEmployee(int id) {
		try {
	        repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: "+id));
	        repo.deleteById(id);
	        return "{message: 'Employee with ID:"+id+" got removed.'}";
	    } catch (Exception e) {
	        registry.counter("service.employee.delete.error").increment();
	        logger.error("Getting error deleting employee with ID.", e);
	        throw e;
	    }
	}


	@Override
	public Optional<Employee> getEmployeebyId(int id) {
		try {
	        return Optional.ofNullable(repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: "+id)));
	    } catch (Exception e) {
	        registry.counter("service.employee.get.error").increment();
	        logger.error("Getting error fetching employee with ID.", e);
	        throw e;
	    }
	}


	@Override
	public List<Employee> listAllEmployee() {
		try {
	        return repo.findAll();
	    } catch (Exception e) {
	        registry.counter("service.employee.listAll.error").increment();
	        logger.error("Error in Listing all employees.", e);
	        throw e;
	    }
	}

}
