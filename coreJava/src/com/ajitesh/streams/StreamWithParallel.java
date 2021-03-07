package com.ajitesh.streams;

import java.util.Arrays;
import java.util.List;

import com.ajitesh.model.Employee;

public class StreamWithParallel {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		list.parallelStream()
			.filter(s -> {
				System.out.println("thread (filter): " + Thread.currentThread().getName());
				return true;
			}).map(s -> {
				System.out.println("thread (map): " + Thread.currentThread().getName());
				return s.toUpperCase();
			}).sorted((s1, s2) -> {
				System.out.println("thread (sort): " + Thread.currentThread().getName());
				return s1.compareTo(s2);
				
			}).forEach(s -> {
				System.out.println("thread (forEach): " + Thread.currentThread().getName());
				System.out.println(s);
			});
		
		List<Employee> emps = Arrays.asList(
				new Employee("Ajitesh", 30),
				new Employee("Sam", 20),
				new Employee("Jack", 20),
				new Employee("Peter", 25),
				new Employee("Ram", 15)
				);
		
		int totalAge = emps.parallelStream()
			.reduce(0, (sum, e) -> {
				System.out.format("accumulator: sum=%s; person=%s [%s]\n",
		                sum, e, Thread.currentThread().getName());
				 return sum += e.getAge();
			},
					(sum1, sum2) -> {
						System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
				                sum1, sum2, Thread.currentThread().getName());
						return sum1 + sum2;
					});
		
		System.out.println("total age : " +  totalAge);
	}

}
