package com.example.test_1.Exception;

public class EmployeeNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
        super(message);
    }
}
