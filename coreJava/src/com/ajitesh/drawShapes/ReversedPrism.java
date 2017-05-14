package com.ajitesh.drawShapes;

public class ReversedPrism {
	
	public static void main(String[] args) {
		createReversedPrism(12);
		
		
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
