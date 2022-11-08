package com.luv2code.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SumToTarget {
	
	// [-1,3,8,2,9,5]
	// [4,1,2,10,5,20]
	// target :24;
	
	public static int[] sumToTarget(int[] arr1, int[] arr2, int target) {
		
		// 1. Loop over first array add into hashSet
		Set<Integer> setArr1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());		
		System.out.println(setArr1);
		int i=0;
		int arr2Size = arr2.length;

		while(i < arr2Size) {
			
			i++;
		}
		
		return arr2;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {-1,3,8,2,9,5};
		int[] arr2 = {4,1,2,10,5,20};
		int target = 24;
		sumToTarget(arr1,arr2,target);
	}
	
	
	
}
