package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

	private Map<String, Employee> employeeMap;

	public EmployeeDaoImpl() {
		employeeMap = new HashMap<String, Employee>();

	}

	@Override
	public Collection<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeMap.values();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("putting new employee to employee map");
		employeeMap.put(UUID.randomUUID().toString(), employee);
		return employee;
	}

}
