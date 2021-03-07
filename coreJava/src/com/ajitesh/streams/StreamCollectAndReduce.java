package com.ajitesh.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.ajitesh.model.Employee;

public class StreamCollectAndReduce {
	
	public static void main(String[] args) {
		
		
		List<Employee> empList = Arrays.asList(
				new Employee("Ajitesh", 30),
				new Employee("Sam", 20),
				new Employee("Jack", 20),
				new Employee("Peter", 25),
				new Employee("Ram", 15)
				);
		
		System.out.println("empList :  " +  empList);
		
		List<Employee> filtered =
				empList
			        .stream()
			        .filter(p -> p.getFirstName().startsWith("P"))
			        .collect(Collectors.toList());
		
		System.out.println("filtered Employee : " + filtered);
		
		Map<Integer, List<Employee>> empByAge = empList.stream()
											    		.collect(Collectors.groupingBy(p -> p.getAge()));

		empByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

		IntSummaryStatistics ageSummary =
				empList
			        .stream()
			        .collect(Collectors.summarizingInt(p -> p.getAge()));

			System.out.println(ageSummary);
			
			String phrase = empList
				    .stream()
				    .filter(p -> p.getAge() >= 18)
				    .map(p -> p.getFirstName())
				    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
			
			System.out.println(phrase);
			
			Map<Integer, String> map = empList
				    .stream()
				    .collect(Collectors.toMap(
				        p -> p.getAge(),
				        p -> p.getFirstName(),
				        (name1, name2) -> name1 + "," + name2));

				System.out.println(map);

	
	/**
	 * We want to transform all persons of the stream into a single string consisting of all names 
	 * in upper letters separated by the | pipe character. In order 
	 * to achieve this we create a new collector via Collector.of()
	 */
				
		String names = empList.stream()
				.map(e -> e.getFirstName().toUpperCase())
				.collect(Collectors.joining(" | "));
		
		System.out.println(names);
		
		Collector<Employee, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          			// supplier
			        (j, p) -> j.add(p.getFirstName()),  				// accumulator
			        (j1, j2) -> j1.merge(j2),               			// combiner
			        StringJoiner::toString);     						// finisher
	
	
		names = empList.stream().collect(personNameCollector);
		
		System.out.println(names);
	}

}
