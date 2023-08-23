package com.example.test_1.Repository;
import com.example.test_1.Entity.Employee;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
}
