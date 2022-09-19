package com.luv2code.practice;
import java.util.Arrays;
import java.util.HashMap;

public class MergeSort {
	
	
	
	public static void main(String[] args) {
		int[] unsorted = {2,4,1,8,5,3};
		System.out.println("sortedArr :: "+  Arrays.toString(mergeSort(unsorted))  );
	}
	
	static int[] mergeSort(int[] arr) {
		
		int n = arr.length;
		if(arr == null || n <2) {
			return arr;
		}
		
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, n/2));
		int[] right = mergeSort(Arrays.copyOfRange(arr, n/2, n));
		
		return mergeStep(arr,left,right);
	}
	
	static int[] mergeStep(int[] arr, int[] left , int[] right) {
		
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i < leftSize && j < rightSize) {
			if(left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		
		while(i < leftSize) {
			arr[k]= left[i];
			i++;
			k++;
		}
		
		while(j< rightSize) {
			arr[k]= right[j];
			j++;
			k++;
		}
		
		return arr;
	}
}
