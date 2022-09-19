package com.luv2code.practice;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class TwoNumSum {

	List<LinkedList<Integer>> adjList;
	int vertexSize;

	public TwoNumSum(int vertexSize) {
		this.vertexSize = vertexSize;
		adjList = new ArrayList<>(vertexSize);
		int i = 0;
		while (i < vertexSize) {
			adjList.add(i, new LinkedList<>());
			i++;
		}

	}

	void addEdges(int v, int e) {
		adjList.get(v).add(e);
	}

	void addEdgesBothWays(int source, int destination) {
		adjList.get(source).add(destination);
		adjList.get(destination).add(source);
	}

	void traverseGraphBFS(int source, int destination) {

		// edge cases conditions 
		// is node already visited
		// is queue is empty;
		
		// key things
		// visited , Queue 
	
		boolean[] visited = new boolean[vertexSize];
		Queue<Integer> q=  new LinkedList<>();
		
		q.add(source);
		visited[source] = true;
		
		while(!q.isEmpty()) {
			
			int currNode = q.poll();					
			System.out.print(currNode+" ");

			Iterator<Integer> adjs = adjList.get(currNode).iterator();
			while(adjs.hasNext()) {
				int n = adjs.next();

				if(!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
		
	
	
	}

	public static void main(String[] args) {
		TwoNumSum graph = new TwoNumSum(5);

		graph.addEdgesBothWays(0, 1);
		graph.addEdgesBothWays(1, 2);
		graph.addEdgesBothWays(2, 3);
		graph.addEdgesBothWays(3, 4);
		graph.addEdgesBothWays(0, 4);
		graph.addEdgesBothWays(2, 4);

		graph.traverseGraphBFS(0,3);

	}

}
