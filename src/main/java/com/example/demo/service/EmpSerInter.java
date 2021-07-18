package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmpSerInter {

	List<Employee> findAll();

	Employee addEmployee(Employee employee);
	
	Employee findEmp(Long id);

	void delete(long id);

}
