package com.ajitesh.streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import oracle.sql.CharacterSet;

public class StreamTest {
	
	public static final int   MAX_VALUE = 0x7fffffff;

	public static void main(String[] args) {

		System.out.println("Hello Streams ...");

		Stream.of("Hello", "Streams").forEach(System.out::println);

		int[] iarr = { 1, 3, 7, 5, 8, 2, 9, 6, 5, 4 };

		Arrays.sort(iarr);
		IntStream.of(iarr).forEach(x -> System.out.print(x));

		StreamTest st = new StreamTest();
		
		System.out.println("\nmax value : " + MAX_VALUE);

	/*	Object ref = new int[] { 1, 2, 3 }; // valid statement?
		Object[] ref2 = new int[] { 1, 2, 3 }; // valid statement?
*/
		System.out.println("\n####################");
		st.call("☺");
		st.call('☺');
		st.call(new Character('☺'));
		st.call((short)'☺');
		st.call((byte)'☺');
		st.call((long)'☺');
	}

	public void call(String str) {
		System.out.println("String " + str);
	}
	
	public void call(short str) {
		System.out.println("short : " + str);
	}
	
	public void call(Short str) {
		System.out.println("Short : " + str);
	}

	public void call(char c) {
		System.out.println("char : " + c);
	}
	public void call(Character str) {
		System.out.println("Character : " + str);
	}

	public void call(byte str) {
		System.out.println("byte : " + str);
	}

	public void call(Byte str) {
		System.out.println("Byte : " + str);
	}

	public void call(long str) {
		System.out.println("long " + str);
	}

	public void call(Long str) {
		System.out.println("Long " + str);
	}
	
	public void call(int str) {
		System.out.println("int : " + str);
	}

	public void call(Integer str) {
		System.out.println("Integer " + str);
	}
	
	public void call(Object str) {
		System.out.println("Object " + str);
	}

}
