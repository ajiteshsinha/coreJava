package com.ajitesh.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAdvanceFunctions {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		list.stream()
			.findFirst().ifPresent(System.out::println);
		
		boolean res = list.stream().noneMatch(s -> s.equals("d1"));
		System.out.println("Res : " + res);
		 res = list.stream().anyMatch(s -> s.equals("c1"));
		 System.out.println("Res : " + res);
		 
		 
		res = list.stream().allMatch(s -> s.equals("c1"));
		
		 System.out.println("Res : " + res);
		 
		 
		 //changing to primitive type
		 Stream.of("a1", "a2", "a3").map(s -> s.substring(1))
								    .mapToInt(Integer::parseInt)
								    .max()
								    .ifPresent(System.out::println); 
		 
		 //changing to Object stream
		 IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);
		 
		 
		 //Getting supllier of Stream
		 Supplier<Stream<String>> streamSupplier = () -> Arrays.asList("a1", "a2", "b1", "c2", "c1").stream();
		 
	
		 streamSupplier.get().anyMatch(s -> true);
		 streamSupplier.get().anyMatch(s -> true);
		 
		 
		 //processing order (filter -> forEach)
		 Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
		 System.out.println();
		 System.out.println("#### 1111 ###  //vertical movements of each element in the stream operations");
		 Stream.of("d2", "a2", "b1", "b3", "c")
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .anyMatch(s -> {
		        System.out.println("anyMatch: " + s);
		        return s.startsWith("A");
		  });
		 
		 
		 System.out.println("#### 1111 ###  //moving filter ahead of map , makes less map call and faster execution");
		 Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
		 
		 System.out.println("#### 1122 ###  // sorting optimization");
		
		 
		 Stream.of("d2", "a2", "b1", "b3", "c")
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
		 
		

		 System.out.println("#### 2222 ###");
		 Stream.of("d2", "a2", "b1", "b3", "c")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return s.startsWith("a");
		    })
		    .sorted((s1, s2) -> {
		        System.out.printf("sort: %s; %s\n", s1, s2);
		        return s1.compareTo(s2);
		    })
		    .map(s -> {
		        System.out.println("map: " + s);
		        return s.toUpperCase();
		    })
		    .forEach(s -> System.out.println("forEach: " + s));
		
	}

}
