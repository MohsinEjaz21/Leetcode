package com.luv2code.practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFSImpl4 {
	HashMap<String, List<Node>> adjListMap;
	int noOfVertices, noOfEdges;

	public BFSImpl4(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		adjListMap = new HashMap<>();
	}

	static class Node {
		String vertex;
		int cost;

		public Node(String vertex, int cost) {
			super();
			this.cost = cost;
			this.vertex = vertex;
		}

		@Override
		public String toString() {
			return "Node [node=" + vertex + ", cost=" + cost + "]";
		}

	}

	void addNode(String key, List<Node> value) {
		adjListMap.put(key, value);
	}

	void printAdjList() {
		for (Entry<String, List<Node>> adjKeySet : adjListMap.entrySet()) {
			System.out.println("key :: " + adjKeySet.getKey());
			System.out.println("value :: " + adjKeySet.getValue());
		}
	}

	void traverseFromSource(Node startNode, Node endNode) {
		Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		HashMap<String, Integer> distance = new HashMap<>();
		HashMap<String, String> path = new HashMap<>();

		q.add(startNode);
		distance.put(startNode.vertex, 0);

		while (!q.isEmpty()) {
			String parentVertex = q.poll().vertex;
			List<Node> adjList = adjListMap.get(parentVertex);

			for (Node neighbor : adjList) {
				String neighborVertex = neighbor.vertex;
				int neighborCost = neighbor.cost;
				
				int newDistance = distance.get(parentVertex) + neighborCost;
				Integer prevDistance = distance.get(neighborVertex);

				boolean isShortestPath = prevDistance != null && newDistance < prevDistance;
				boolean isVisited = distance.containsKey(neighborVertex);

				if (!isVisited || isShortestPath) {
					distance.put(neighborVertex, newDistance);
					q.add(neighbor);							
					String prevParentPath = path.containsKey(parentVertex) ? path.get(parentVertex) : "";
					path.put(neighborVertex, prevParentPath + parentVertex);
				}
			}

		}

		System.out.println("distance : " + distance);
		System.out.println("path : " + path);

	}

	public static void main(String[] args) {
		BFSImpl4 graph = new BFSImpl4(5, 7);

		graph.addNode("A", Arrays.asList(new Node("B", 5), new Node("D", 2)));
		graph.addNode("B", Arrays.asList(new Node("D", 1), new Node("E", 5)));
		graph.addNode("C", Arrays.asList(new Node("A", 4), new Node("D", 7)));
		graph.addNode("D", Arrays.asList(new Node("E", 2)));
		graph.addNode("E", new ArrayList<Node>());
//		graph.printAdjList();

		graph.traverseFromSource(new Node("A", 0), new Node("D", 0));
//		for(String key: graph.adjListMap.keySet()) {
//			System.out.println("Starting Node :: "+key);
//			graph.traverseFromSource(key);			
//		}

//  		graph.shortestReach(1,3);
	}

}
