package com.luv2code.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijesktra4 {
	HashMap<String, List<Node>> adjListMap;
	int noOfVertices, noOfEdges;

	public Dijesktra4(int noOfVertices, int noOfEdges) {
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

	void findShortestRoute(Node startNode) {
		// create priorityQueue pq;
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		HashMap<String,Integer> distanceMap = new HashMap<>();
		HashMap<String,String> pathMap = new HashMap<>();
		
		pq.add(startNode);
		distanceMap.put(startNode.vertex, 0);
		
		while(!pq.isEmpty()) {
			
			Node parentNode = pq.poll();
			List<Node> adjNodes = adjListMap.get(parentNode.vertex);
			
			for(Node adjNode :adjNodes) {
				int uptoParentDistance = distanceMap.get(parentNode.vertex);
				int newDistance = uptoParentDistance + adjNode.cost;
				Integer prevDistance  = distanceMap.get(adjNode.vertex);
				boolean isPathShortest = prevDistance !=null && newDistance < prevDistance;
				boolean isVisted = distanceMap.containsKey(adjNode.vertex);
				if(!isVisted || isPathShortest) {
					pq.add(adjNode);
					distanceMap.put(adjNode.vertex,newDistance);
					
					String prevPath = pathMap.get(parentNode.vertex)!=null ? pathMap.get(parentNode.vertex) : "";
					pathMap.put(adjNode.vertex,  prevPath + parentNode.vertex );
				}
			}
			
		}
		
		System.out.println(distanceMap);
		System.out.println(pathMap);

		// add the startNode to pq
		
	}
	

	public static void main(String[] args) {
		Dijesktra4 graph = new Dijesktra4(5, 7);

		graph.addNode("A", Arrays.asList(new Node("B", 5), new Node("D", 2)));
		graph.addNode("B", Arrays.asList(new Node("D", 1), new Node("E", 5)));
		graph.addNode("C", Arrays.asList(new Node("A", 4), new Node("D", 7)));
		graph.addNode("D", Arrays.asList(new Node("E", 2)));
		graph.addNode("E", new ArrayList<Node>());
//		graph.printAdjList();

		graph.findShortestRoute(new Node("A", 0));
//		for(String key: graph.adjListMap.keySet()) {
//			System.out.println("Starting Node :: "+key);
//			graph.traverseFromSource(key);			
//		}

//  		graph.shortestReach(1,3);
	}

}


