package com.ajitesh.drawShapes;

/**
 * 
 * @author Ajitesh
 * @date May 15 2017
 * One of the asked question at interview....
 *
 */
public class ReversedPrism {
	
	public static void main(String[] args) {
		createReversedPrism(11);
		
		
	}
	
	
	public static  void createReversedPrism(int n){
		
		for(int i = n; i >= 1; i-=2 ){
			for(int k = 1; k <= n-i; k+=2 ){
				System.out.print(" ");
			}
			for(int j = i; j >= 1; j-- ){
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
