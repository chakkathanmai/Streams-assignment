package com.training.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import java.util.Scanner;

//implementing comparator
class NameSort implements Comparator<Employee>{
	@Override
	public int compare(Employee emp1, Employee emp2) {
		// TODO Auto-generated method stub
		return emp1.name.compareTo(emp2.name);
	}
	
}

public class EmpMain {

	public static void main(String[] args) {
		// Adding 5 Employee objects to list
		List<Employee> EmpList = Arrays.asList(new Employee("sita", "chennai", 21),
				new Employee("meena", "chennai", 22), new Employee("ram", "hyderabad", 23),
				new Employee("iran", "hyderabad", 24), new Employee("kavitha", "pune", 25));
		// printing all employees using for-each
		for (Employee Emps : EmpList) {
			System.out.println(Emps);
		}
		System.out.println();
		System.out.println("Enter the city name");
		Scanner sc = new Scanner(System.in);
		String givencity = sc.next();

		// converting list to stream
		Stream<Employee> EmpStream = EmpList
				.stream()
		
	   // filtering employee based on given city
		.filter((W) -> W.city.equals(givencity));
		Iterator<Employee> i = EmpStream.iterator();
		while (i.hasNext()) {
			Employee emp = i.next();
			System.out.println(emp);
		}
		System.out.println();
		System.out.println("Sorting employees based on Names");
		//sorting Employees based on name
		NameSort names = new NameSort();
		Collections.sort(EmpList,names);
		Iterator<Employee> j =EmpList.iterator();
		while (j.hasNext()) {
			Employee emp = j.next();
			System.out.println(emp);
		}
		
		//Printing Employees by id 
		System.out.println("Enter the employeeId to find");
		int id=sc.nextInt();
		try {
			Employee emp =EmpList.stream().filter((K)->K.empid==(id))
					.findFirst()
					.orElseThrow(()->new Exception("Employee Not found"));
			System.out.println("Employee:" +emp);
		}catch(Exception e){
			System.out.println(e);
		}
		
		//Employee names that starts with K
		System.out.println("Employees whoes name strats with K");
		try {
		Employee emp=EmpList.stream().filter((E)->E.name.startsWith("k")).findFirst().orElseThrow(()->new Exception("No Employee with K"));
		System.out.println("Employee:" +emp);
		}catch(Exception e) {
			System.out.println(e);
		}
			sc.close();	
	}
}


