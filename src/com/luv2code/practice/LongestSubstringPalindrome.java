package com.luv2code.practice;

public class LongestSubstringPalindrome {
	
	
	public static void main(String[] args) {
		String longestPalindrome = extractLongestPalindrome();
		System.out.println(longestPalindrome);
	}
	
	public static boolean isPalindrome(String str) {
		int i=0;
		int j= str.length()-1;
		
		while( i < j) {
			if(str.charAt(i) !=  str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		
		return true;		
	}

	protected static String extractLongestPalindrome() {
		String str = "aaabbaaa";
		int longestLen = 0;
		int strSize = str.length();
		String palindromeStr = "";

		for(int i=0; i< strSize; i++) {
			for(int j=0; j < strSize; j++) {
				if(i != j) {
					String s = "";
					if(i < j) {
						s = str.substring(i, j+1);						
					}else {
						s = str.substring(j, i+1);						
					}
					boolean isPalindrome = isPalindrome(s);
					System.out.println(s+" "+isPalindrome);
					if(isPalindrome && s.length() > longestLen) {
						longestLen = s.length();
						palindromeStr = s;
					}
				}
			}
		}
		return palindromeStr;
	}

}
