package com.example.test_1.DTO;

import javax.validation.constraints.NotNull;

public class Employeedto {
    @NotNull(message = "First name cannot be null") private String first_name;
	@NotNull(message = "Last name cannot be null") private String last_name;
	@NotNull(message = "Email cannot be null") private String email;
	@NotNull private String phone_number;
	@NotNull private String job_title;
	@NotNull private String department;

    public Employeedto(){}
    
    public Employeedto(String first_name, String last_name, String email, String phone_number, String job_title,
    String department){
        this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.job_title = job_title;
		this.department = department;
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
		return "Employee [first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", phone_number=" + phone_number + ", job_title=" + job_title + ", department=" + department + "]";
	}
}
