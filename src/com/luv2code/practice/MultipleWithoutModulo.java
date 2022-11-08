package com.luv2code.practice;

public class MultipleWithoutModulo {
	static int num = 12;
	
	public static boolean isDivisible2(int num,int multipleOf) {
		if((num/multipleOf)*multipleOf == num) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isDivisible2(22,11));
	}
	
}
