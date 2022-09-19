package com.luv2code.practice;

public class LossyCompression {
	
	static String encode(String s) {
		char[] charArr = s.toCharArray();
		StringBuilder sb= new StringBuilder();
		
		int j=0,count=0;
		for(int i=0; i<charArr.length;i=j) {
			while(j<charArr.length && charArr[i] == charArr[j]) {
				count++;
				j++;
			}
			sb.append(count).append(charArr[i]);
			count=0;
		}
		return sb.toString();
	}
	// "aaaccbdd"
	// "3a2c1b2d"
	public static void main(String[] args) {
		encode("aaaccbdd");
		System.out.print(encode("aaaccbdd"));
	}

}
