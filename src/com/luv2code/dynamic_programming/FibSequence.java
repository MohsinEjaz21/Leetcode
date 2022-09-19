package com.luv2code.dynamic_programming;

import java.util.HashMap;

public class FibSequence {

	/*	
		- Recursion
		- Store Intermediate Result (Memoization)
		- Bottom-up
	*/
	
	static HashMap<Integer, Integer> fibSeqMap = new HashMap<>();
	
	static int fibSeq(int n) {
		
		if(n==0) {
			return 0;
		}
		
		if(n<=2) {
			return 1;
		}

		if(fibSeqMap.get(n) != null) {
			return fibSeqMap.get(n);
		}else {
			int result = fibSeq(n-1)+ fibSeq(n-2);
			fibSeqMap.put(n, result);
			return result;
		}
	}
	
	static int fibSeqWithoutMemo(int n) {
		if(n==0) {
			return 0;
		}
		if(n<=2) {
			return 1;
		}
		return fibSeqWithoutMemo(n-1) + fibSeqWithoutMemo(n-2);
	}
	
	public static void main(String[] args) {
//		System.out.println(fibSeqWithoutMemo(20));
		System.out.println(fibSeq(20));

	}

}
