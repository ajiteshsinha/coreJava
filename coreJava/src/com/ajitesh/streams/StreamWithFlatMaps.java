package com.ajitesh.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}

class Outer {
	Nested nested =  new Nested();
}

class Nested {
	Inner inner =  new Inner();
}

class Inner {
	String foo = "Ajitesh";
}

public class StreamWithFlatMaps {

	public static void main(String[] args) {
		
		List<Foo> fooList = IntStream.range(1, 4)
								.mapToObj(i -> new Foo("Foo" +  i))
								.collect(Collectors.toList());
		
		
		fooList.forEach( f -> {
			/*f.bars = IntStream.range(1, 4).mapToObj(i -> new Bar("Bar<-" +  f.name))
					.collect(Collectors.toList());*/
			 IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar<-" +  f.name)));
		});
		
		
		fooList.stream().flatMap( f -> f.bars.stream())
				.forEach(b -> System.out.println(b.name));
		
		
		IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))
	    .peek(f -> IntStream.range(1, 4)
	        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
	        .forEach(f.bars::add))
	    .flatMap(f -> f.bars.stream())
	    .forEach(b -> System.out.println(b.name));
		
		
		/**
		 * FlatMap with optional
		 */
		Outer outer = new Outer();
		
		Optional.ofNullable(outer)
				.flatMap(o -> Optional.ofNullable(o.nested))
				.flatMap(i -> Optional.ofNullable(i.inner))
				.flatMap(n -> Optional.ofNullable(n))
				.ifPresent(System.out :: println);
		

	}
}
