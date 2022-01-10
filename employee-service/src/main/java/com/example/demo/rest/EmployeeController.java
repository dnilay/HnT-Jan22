package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	private EmployeeDao employeeDao;
	
	private Environment environment;

	@Autowired
	public EmployeeController(EmployeeDao employeeDao,Environment environment) {
		this.employeeDao = employeeDao;
		this.environment=environment;
	}

	@GetMapping("/")
	public String getStatus()
	{
		return "employee service is running on port: "+environment.getProperty("local.server.port");
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();

	}

}
