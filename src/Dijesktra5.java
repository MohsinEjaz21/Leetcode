import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijesktra5 {
	HashMap<String, List<Node>> adjListMap;
	int noOfVertices, noOfEdges;

	public Dijesktra5(int noOfVertices, int noOfEdges) {
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
		// 1.1 create a queue which contains adjacent nodes
		Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));

		// 1.2 create a distance hashmap with key of vertex and its weight;

		HashMap<String, Integer> distanceMap = new HashMap<>();

		// 1.3 create a path which contains shortest path starting from source;

		HashMap<String, String> pathMap = new HashMap<>();

		// distance of startNode to startNode is zero

		distanceMap.put(startNode.vertex, 0);

		while (!pq.isEmpty()) {
			
			// get the front of priority queue
			
			Node parent = pq.poll();
			
			// get the adj List of the cherry picked vertex
			
			List<Node> adjList = adjListMap.get(parent.vertex);
			
			// foreach adj list check already visited or the new calculated distance of adj node is less than the privous
			
			for(Node neighbor : adjList) {
				
				boolean isVisited = distanceMap.containsKey(neighbor.vertex);
				Integer neighborCost = distanceMap.get(neighbor.vertex);
				int newNodeCost = distanceMap.get(parent.vertex) + neighbor.cost;
				boolean isShortestPath = neighborCost != null && newNodeCost < neighborCost;
				
				if(!isVisited || isShortestPath) {
					pq.add(neighbor);
					distanceMap.put( neighbor.vertex , newNodeCost);
					String oldPath = pathMap.get(parent.vertex) != null ? pathMap.get(parent.vertex) :"";
					pathMap.put(neighbor.vertex, oldPath + parent.vertex);		
				}
				
			}
		}
		
		System.out.println(distanceMap);
		System.out.println(pathMap);

	}

	public static void main(String[] args) {
		Dijesktra5 graph = new Dijesktra5(5, 7);

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
