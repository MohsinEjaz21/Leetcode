import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

import com.luv2code.dijesktra.Vertex;

public class BFSImpl4 {
	HashMap<String, List<Node>> adjListMap;
	int noOfVertices, noOfEdges;

	public BFSImpl4(int noOfVertices, int noOfEdges) {
		this.noOfVertices = noOfVertices;
		this.noOfEdges = noOfEdges;
		adjListMap = new HashMap<>();
	}

	static class Node {
		String node;
		int cost;

		public Node(String node, int cost) {
			super();
			this.cost = cost;
			this.node = node;
		}

		@Override
		public String toString() {
			return "Node [node=" + node + ", cost=" + cost + "]";
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
		distance.put(startNode.node, 0);

		while (!q.isEmpty()) {
			Node currNode = q.poll();
			List<Node> adjList = adjListMap.get(currNode.node);

			for (Node neighborNode : adjList) {
				int newDistance = distance.get(currNode.node) + neighborNode.cost;
				Integer prevDistance = distance.get(neighborNode.node);
				boolean isShortestPath = prevDistance != null && newDistance < prevDistance;

				if (!distance.containsKey(neighborNode.node) || isShortestPath) {
					distance.put(neighborNode.node, newDistance);
					q.add(neighborNode);							
					String prevPath = path.get(currNode.node);
					path.put(neighborNode.node, (prevPath != null ? prevPath : "")+ currNode.node);
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
