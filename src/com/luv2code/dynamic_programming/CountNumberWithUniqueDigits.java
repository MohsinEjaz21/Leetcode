package com.luv2code.dynamic_programming;

public class CountNumberWithUniqueDigits {
	public static int countNumberWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int sum = 10;
		int q = 9;
		for (int i = 1; i < n; i++) {
			q = q * (10 - i);
			sum = sum + q;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(countNumberWithUniqueDigits(2));
	}
}
