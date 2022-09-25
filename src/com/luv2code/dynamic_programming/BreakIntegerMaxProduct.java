package com.luv2code.dynamic_programming;

public class BreakIntegerMaxProduct {

//	public static int integerBreak(int n) {
//		int[] dp = new int[n + 1];
//		dp[1] = 1;
//		for (int i = 2; i <= n; i++) {
//			for (int j = 1; j < i; j++) {
//				dp[i] = Math.max(dp[i], (Math.max(j, dp[j])) * (Math.max(i - j, dp[i - j])));
//			}
//		}
//		return dp[n];
//	}

  public static int integerBreak(int n) {
  	int product =1;
  	
  	if(n==2) 
  		// sum = 1+1 =2  , product = 1*1 = 1
  		return 1;
  	
  	if(n==3) {
  		// sum = 2+1 =3  , product = 2 * 1 = 2
  		return 2;
  	}
  	
  	while(n > 4) {
  		product = product * 3;
  		n=n-3;
  	}
  	
  	product = product * n;
  	return product;
  }
	
	
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}

}
