package com.luv2code.practice;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    static Double calculatedMedian(List<Integer> nums){
    	if(nums == null || nums.size() == 0) {
    		return 0.0;
    	}
    	int size = nums.size();

    	if(size < 2) {
    		return (double) nums.get(0);
    	}
    	
    	else if(size%2==0) {
    		int index1 = (size/2 - 1);
    		int index2 = index1+1;
    		System.out.println(index1);

    		return (double) (nums.get(index1) + nums.get(index2))/2;
    	}else {
    		int mid = size/2;
    		return (double) nums.get(mid);
    	}
    	    	
    }
    
    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
    
    // sort input array
    
    List<Double> rs = new ArrayList<>();

    
    for(int i=0; i<a.size();i++){
      List<Integer> subList =  a.subList(0, i+1);
      Collections.sort(subList);
      printSubArray(subList);
      System.out.print("\n");
      rs.add(calculatedMedian(subList));
    }
    
    printSubArray(rs);


    return rs;
    }
    
   static <T> void printSubArray(List<T> subList) {
  	 subList.forEach(System.out::println); 
  	 }

}

public class Median {
    public static void main(String[] args) throws IOException {
      List<Double> result = Result.runningMedian(Arrays.asList(1,21,34,55,22));

    }
}
