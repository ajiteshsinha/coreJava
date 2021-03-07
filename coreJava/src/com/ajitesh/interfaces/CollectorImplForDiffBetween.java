package com.ajitesh.interfaces;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectorImplForDiffBetween {
	
	
	public static void main(String[] args) {
		Stream.of(1, 2, 3, 4, 6, 7, 8)
	    .map(new Function<Integer, Optional<Integer>>() {
	        Optional<Integer> previousValue = Optional.empty();
	        @Override
	        public Optional<Integer> apply(Integer current) {
	            Optional<Integer> value = previousValue.map(previous -> current - previous);
	            previousValue = Optional.of(current);
	            return value;
	        }
	    })
	    .filter(Optional::isPresent)
	    .map(Optional::get)
	    .forEach(System.out::println);
	}
	
	// s.collect(intDifferences()).forEach(d -> System.out.print(d + ","));

	public static Collector<Integer, List<Integer>, Stream<Integer>> intDifferences() {

	    return new Collector<Integer, List<Integer>, Stream<Integer>>() {

	        @Override
	        public BiConsumer<List<Integer>, Integer> accumulator() {
	            return List::add;
	        }

	        @Override
	        public Set<Collector.Characteristics> characteristics() {
	            return EnumSet.noneOf(Collector.Characteristics.class);
	        }

	        @Override
	        public BinaryOperator<List<Integer>> combiner() {
	            return (left, right) -> {
	                left.addAll(right);
	                return left;
	            };
	        }

	        @Override
	        public Function<List<Integer>, Stream<Integer>> finisher() {
	            return list -> {
	                List<Integer> differences = new ArrayList<>();
	                for (int i = 1; i < list.size(); i++) {
	                    differences.add(list.get(i) - list.get(i - 1));
	                }
	                return differences.stream();
	            };
	        }

	        @Override
	        public Supplier<List<Integer>> supplier() {
	            return ArrayList::new;
	        }
	    };
	}
}
