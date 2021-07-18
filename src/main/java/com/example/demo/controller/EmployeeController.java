package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customException.BusinessException;
import com.example.demo.customException.ControllerException;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmpSerInter;

@RestController
@RequestMapping("/user")
public class EmployeeController {

	@Autowired
	EmpSerInter empSerInter;
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		try {
			return new ResponseEntity<List<Employee>>(empSerInter.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			throw new ControllerException("901","Message");
		}
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable long id){
		Employee employeeFetchData=new Employee();
		try {
			employeeFetchData=empSerInter.findEmp(id);
			return new ResponseEntity<Employee>(employeeFetchData,HttpStatus.OK);
		}catch(ControllerException b) {
			ControllerException ce=new ControllerException(b.getErrorCode(),b.getErrorMessage());
			return new ResponseEntity<Employee>(employeeFetchData, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		try {
			Employee employeeSaved= empSerInter.addEmployee(employee);
			return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
		}catch(BusinessException b) {
			ControllerException ce=new ControllerException(b.getErrorCode(),b.getErrorMessage());
//			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
			return null;

		}catch(Exception e) {
			ControllerException ce=new ControllerException("615","Contoller Issue ");
			return null;
//			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> removeEmployee(@PathVariable long id){
		empSerInter.delete(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
	}
	
}
