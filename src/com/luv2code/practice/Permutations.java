package com.luv2code.practice;
import java.util.*;

import javax.lang.model.util.Elements;

public class Permutations {

  static Set<List<Integer>> rs = new HashSet<>(); 
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
  	int n= array.size();
  	getPermutationsHelper( n, array);
  	System.out.println(rs.size());
    return new ArrayList<>(rs) ;
  }

  public static void getPermutationsHelper(int n,List<Integer> elements) {
  	 elements = new ArrayList<>(elements);

   if(n==1) {
  	 rs.add(elements);
   }else {
  	 
  	 for(int i=0; i<n-1;i++) {
  		 getPermutationsHelper(n-1,elements);
  		 if(n%2 == 0) {
  			 swap(elements,i,n-1);
  		 }else {
  			  swap(elements,0,n-1);
  		 }
  		 getPermutationsHelper(n-1, elements);

  	 }
   }
  }
 
  private static void swap(List<Integer> input, int a, int b) {
    Integer temp =input.get(a);
    input.set(a, input.get(b));
    input.set(b,temp);
}
  
  public static void main(String[] args) {
  	Integer[] temp = {1, 2, 3};
		System.out.println(getPermutations(Arrays.asList(temp)));
	}

}
