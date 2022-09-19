package com.luv2code.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	 static class Subsets<T> {
		public List<List<T>> allSubSets(List<T> list) {
			List<List<T>> out = new ArrayList<List<T>>();
			for (int i = 1; i <= list.size(); i++) {
				List<List<T>> outAux = this.subSets(list, i);
				out.addAll(outAux);
			}
			return out;
		}

		public List<List<T>> subSets(List<T> list, int size) {
			List<List<T>> out = new ArrayList<List<T>>();
			for (int i = 0; i < list.size() - size + 1; i++) {
				List<T> subset = new ArrayList<T>();
				for (int j = i; j < i + size - 1; j++) {
					subset.add(list.get(j));
				}
				if (!(size == 1 && i > 0)) {
					for (int j = i + size - 1; j < list.size(); j++) {
						List<T> newsubset = new ArrayList<T>(subset);
						newsubset.add(list.get(j));
						out.add(newsubset);
					}
				}
			}
			return out;
		}
	
	}
		public static void main(String[] args) {
			Subsets<Integer> aux = new Subsets<Integer>();
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			list.add(2);
			list.add(3);
			list.add(4);
			list.add(5);
			List<List<Integer>> out = aux.subSets(list,3);
			System.out.println(out);
		}

}