package com.luv2code.practice;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class DFSImpl1 {

	List<LinkedList<Integer>> adjList;
	int vertexSize;

	public DFSImpl1(int vertexSize) {
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

	void traverseGraphDFS(int source, int destination) {

		// edge cases conditions 
		// is node already visited
		// is queue is empty;
		
		// key things
		// visited , Queue 
	
		boolean[] visited = new boolean[vertexSize];
		List<Integer> s=  new ArrayList<>();
		
		s.add(source);
		visited[source] = true;
		
		while(!s.isEmpty()) {
			
			int currNode = s.remove(s.size()-1);					
			System.out.print(currNode+" ");

			Iterator<Integer> adjs = adjList.get(currNode).iterator();
			while(adjs.hasNext()) {
				int n = adjs.next();

				if(!visited[n]) {
					visited[n] = true;
					s.add(n);
				}
			}
		}
		
	
	
	}

	public static void main(String[] args) {
		DFSImpl1 graph = new DFSImpl1(5);

		graph.addEdgesBothWays(0, 1);
		graph.addEdgesBothWays(1, 2);
		graph.addEdgesBothWays(2, 3);
		graph.addEdgesBothWays(3, 4);
		graph.addEdgesBothWays(0, 4);
		graph.addEdgesBothWays(2, 4);

		graph.traverseGraphDFS(0,3);

	}

}
