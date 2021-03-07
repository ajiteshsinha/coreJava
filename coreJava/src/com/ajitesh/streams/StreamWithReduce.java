package com.ajitesh.streams;

import java.util.Arrays;
import java.util.List;

import com.ajitesh.model.Employee;

public class StreamWithReduce {
	
	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Ajitesh", 30),
				new Employee("Sam", 20),
				new Employee("Jack", 20),
				new Employee("Peter", 25),
				new Employee("Ram", 65)
				);
		
		
		empList
	    .stream()
	    .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
	    .ifPresent(System.out::println);    // Ram
		
		
		Employee result =
				empList
			        .stream()
			        .reduce(new Employee("", 0), (p1, p2) -> {
			        	p1.setAge(p1.getAge() + p2.getAge());
			        	p1.setFirstName(p1.getFirstName() + p2.getFirstName());
			            return p1;
			        });
		
		
		
		System.out.format("name=%s; age=%s", result.getFirstName(), result.getAge());
		System.out.println();
		String names =
				empList
			        .stream()
			        .reduce("", (p1, p2) -> {
				        	p1 += p2.getFirstName();
			            return p1;
			        },
			       (s1, s2) -> s1 + s2);
		
		System.out.println(names);
	}

}
