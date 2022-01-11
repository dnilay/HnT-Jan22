package com.example.demo.dao;

import java.util.Collection;

import com.example.demo.model.Employee;

public interface EmployeeDao {

	public Collection<Employee> getAllEmployees();
	
	public Employee createEmployee(Employee employee);
	
	public Employee findEmployeeByEmployeeId(String employeeId);

}
