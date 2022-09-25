package com.luv2code.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] numbers, int target) {
		int[] rs = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int size = numbers.length;

		while (i < size) {
			if (map.containsKey(target - numbers[i])) {
				rs[0] = i;
				rs[1] = map.get(target - numbers[i]);
				return rs;
			} else {
				map.put(numbers[i], i);
			}
			i++;
		}
		return rs;
	}

	public static void main(String[] args) {
		int[] temp = {1,2,5,10};
		int[] rs = twoSum(temp,6);
		System.out.println("twosum "+Arrays.toString(rs));

		int mask = 0x000F;
		int value = 0x2222;
		System.out.println(value & mask);
	
	}
	

	
	
}
