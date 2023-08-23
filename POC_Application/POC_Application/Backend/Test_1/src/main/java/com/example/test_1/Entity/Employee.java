package com.example.test_1.Entity;

import com.example.test_1.Audit.Auditable;
import javax.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name="Employees", schema = "application")
public class Employee extends Auditable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="first_name")
	@NotNull
	private String first_name;
	//no need for the other once since we're giving the same name to all. 
	private String last_name;
	private String email;
	private String phone_number;
	private String job_title;
	private String department;
	
	//constructor adding
	public Employee() {}
	
	public Employee(int id, String first_name, String last_name, String email, String phone_number, String job_title,
			String department) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.job_title = job_title;
		this.department = department;
	}
	
	//getter and setter in the last.
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	//toString function as well.
	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone_number=" + phone_number + ", job_title=" + job_title + ", department=" + department + "]";
	}
}
