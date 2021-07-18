package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeCrudRepo;
import com.example.demo.customException.BusinessException;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService implements EmpSerInter {
	
	@Autowired
	EmployeeCrudRepo empRepo;
	
	@Override
	public List<Employee> findAll(){
		try {
			List<Employee> employees= empRepo.findAll();
			if(employees.isEmpty()) {
				throw new BusinessException("605","Employee details are not found");
			}
			return employees;
		}catch(Exception e) {
			throw new BusinessException("606","Issue with Service Layer"+e.getMessage());
		}
		
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			if(employee.getName().isEmpty() || employee.getName().length()==0) {
				throw new BusinessException("601","Please send proper Name");
			}
			Employee savedEmployee= empRepo.save(employee);
			return savedEmployee;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602","Employee Name is Null"+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603","Something went wrong in service Layer is Null"+e.getMessage());
		}
		
		
	}

	@Override
	public Employee findEmp(Long id) {	
		try {
			Employee employee=empRepo.findById(id).get();
			return employee;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608","Issue with Service Layer"+e.getMessage());
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("609","Doesnot exist"+e.getMessage());
		}
		
	}

	@Override
	public void delete(long id) {
		try {
			empRepo.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("610","Issue with Service Layer"+e.getMessage());
		}catch(java.util.NoSuchElementException e) {
			throw new BusinessException("611","Doesnot exist"+e.getMessage());
		}
		
		
	}
	
}
