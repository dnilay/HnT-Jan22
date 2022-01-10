package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> employees;
	
	{
		employees=new ArrayList<Employee>();
		employees.add(new Employee(UUID.randomUUID().toString(), "John", "Doe", "john@email.com"));
		employees.add(new Employee(UUID.randomUUID().toString(), "Marry", "Public", "marry@email.com"));
		employees.add(new Employee(UUID.randomUUID().toString(), "Rahul", "Dravid", "rahul@email.com"));
		employees.add(new Employee(UUID.randomUUID().toString(), "Jonty", "Roads", "jonty@email.com"));
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employees;
	}

}
