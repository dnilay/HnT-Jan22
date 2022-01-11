package com.example.demo.rest;

import java.util.Collection;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	private EmployeeDao employeeDao;

	private Environment environment;

	@Autowired
	public EmployeeController(EmployeeDao employeeDao, Environment environment) {
		this.employeeDao = employeeDao;
		this.environment = environment;
	}

	@GetMapping("/")
	public String getStatus() {
		return "employee service is running on port: " + environment.getProperty("local.server.port");
	}

	@GetMapping("/employees")
	public ResponseEntity<Collection<Employee>> getAllEmployees() {
		

		return ResponseEntity.status(HttpStatus.OK).body(employeeDao.getAllEmployees());

	}
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
	{
		String str[]=UUID.randomUUID().toString().split("-");
		log.info("setting the employee id");
		employee.setEmployeeId(str[0]);
		log.info("returning newly created employee {}",employee);
		return ResponseEntity.status(HttpStatus.CREATED).body( employeeDao.createEmployee(employee));
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> findEmployee(@PathVariable("employeeId") String employeeId)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeDao.findEmployeeByEmployeeId(employeeId));
	}

}
