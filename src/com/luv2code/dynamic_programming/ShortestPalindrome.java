package com.luv2code.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortestPalindrome {

	static List<String> uniqueChar(String s, int size) {
		int i = 0;
		List<String> temp = new ArrayList<>();
		while (i < size) {
			String v = String.valueOf(s.charAt(i));
			if (!temp.contains(v)) {
				temp.add(v);
			}
			i++;
		}

		return temp;
	}

	static boolean checkPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		int size = s.length();
		int i = size - 1;
		while (i > -1) {
			sb.append(s.charAt(i));
			i--;
		}
		String reverse = sb.toString();
		System.out.println("string :" + s);
		System.out.println("reverse :" + reverse);

		if (reverse.equals(s)) {
			return true;
		}
		return false;
	}

	public String shortestPalindrome(String s) {
		int i = 0;
		int size = s.length();
		List<String> uniqueChars = uniqueChar(s, size);
		System.out.println(uniqueChars.get(0));
		int uniqueCharsSize = uniqueChars.size();
		System.out.println("uniqueChars :" + uniqueChars.get(0));
		System.out.println("uniqueCharsSize :" + uniqueCharsSize);

		while (i < uniqueCharsSize) {
			String tempStr = combineStrUptoIndex(uniqueChars, i);
			String newStr = tempStr + s;
			if (checkPalindrome(newStr)) {
				return newStr;
			}

			List<String> perms = permutations(tempStr);
			for (String ss : perms) {
				String xx = ss + s;
				if (checkPalindrome(xx)) {
					return xx;
				}
			}

			i++;
		}

		return "";
	}

	static String combineStrUptoIndex(List<String> charList, int index) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int j = i + 1;
		while (i <= index) {
			sb.append(charList.get(i));
			i++;
		}
		return sb.toString();
	}

	public static List<String> permutations(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}

		List<String> partial = new ArrayList<>();
		partial.add(String.valueOf(str.charAt(0)));

		for (int i = 1; i < str.length(); i++) {
			for (int j = partial.size() - 1; j >= 0; j--) {
				String s = partial.remove(j);
				for (int k = 0; k <= s.length(); k++) {
					partial.add(s.substring(0, k) + str.charAt(i) + s.substring(k));
				}
			}
		}

		return partial;
	}

	public static void main(String[] args) {
//		int[] temp = { 1, 3, 4, 2, 5 };
//		findCombinations(temp, 2);
//		System.out.println(findCombinations(temp, 3));
	}

}