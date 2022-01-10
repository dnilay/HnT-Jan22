package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {

	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeController(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();

	}

}
