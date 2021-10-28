package com.training.streams;

public class Employee {
	//instance variables 
	String name,city;
      int empid;
      //Parameterized constructor
	public Employee(String name, String city, int empid) {
		super();
		this.name = name;
		this.city = city;
		this.empid = empid;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", empid=" + empid + "]";
	}
	
}
