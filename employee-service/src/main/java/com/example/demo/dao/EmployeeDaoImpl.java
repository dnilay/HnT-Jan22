package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
		System.out.println(employeeMap.keySet());
		return employeeMap.values();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info("putting new employee to employee map");
		employeeMap.put(UUID.randomUUID().toString(), employee);
		return employee;
	}

	@Override
	public Employee findEmployeeByEmployeeId(String employeeId) {
		Collection<Employee> set = employeeMap.values();
		Employee employee = null;
		Iterator<Employee> iterator = set.iterator();
		while (iterator.hasNext()) {
			Employee employee2=iterator.next();
			
			if(employee2.getEmployeeId().equals(employeeId))
			{
				employee=employee2;
			}
				
				
		}

		return employee;
	}

}
