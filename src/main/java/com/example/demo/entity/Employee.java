package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.customException.ControllerException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")
@ToString
public class Employee extends ControllerException{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long id;
	public String name;
	
	public Employee() {
			}
	
	public Employee(long l, String string) {
		super();
		this.id= l;
		this.name=string;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
