package com.luv2code.practice;
import java.util.HashMap;

public class CalculateFact {
	
	public static void main(String[] args) {
		fact(9);
		System.out.println(fact(5));
	}
	
	static int fact(int num) {
		int fact=1, i=0;
		if(num ==0) {
			return fact;
		}
		while(i<num) {
			fact =  fact * (num--);
		}

		return fact;
	}

}
