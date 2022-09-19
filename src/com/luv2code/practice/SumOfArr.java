package com.luv2code.practice;
import java.util.HashMap;

public class SumOfArr {

	public static void main(String[] args) {
		compute(new Integer[]{1,3,5, 7,6,4});

	}

	static void compute(Integer[] arr) {
		
		int i=0,j=0,sum=0, target=13;
		int len = arr.length;
		
		while(i<len) {
			sum= sum + arr[i];
			if(sum == target) {
				break;
			}
			
			i++;

			if(i == len-1 && sum!=target) {
				j++;
				i=j;
				sum=0;
			}			

		}

		System.out.println(j);
		System.out.println(i);
		


	}

}
