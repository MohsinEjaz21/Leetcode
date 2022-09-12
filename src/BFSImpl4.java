import java.util.*;
import java.util.LinkedList;
import java.util.Map.Entry;

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
	  for(Entry<String, List<Node>> adjKeySet : adjListMap.entrySet()) {
	  	System.out.println("key :: "+adjKeySet.getKey());
	  	System.out.println("value :: "+ adjKeySet.getValue());
	  }
	}
	
	 void traverseFromSource(String startNode) {
		Queue<String> q = new LinkedList<>();
		HashMap<String, Integer> distance = new HashMap<>();
		q.add(startNode);
		distance.put(startNode, 0);
		while(!q.isEmpty()) {
			
			String currNode = q.poll();
			System.out.println("currNode :: "+currNode);
			List<Node> adjList = adjListMap.get(currNode);
			
			for(Node neighborNode : adjList) {

				if(distance.containsKey(neighborNode.node)) {
					int newDistance = distance.get(currNode) + neighborNode.cost;
					Integer prevDistance =  distance.get(neighborNode.node);
					if(prevDistance != null && newDistance < prevDistance) {
						distance.put(neighborNode.node, newDistance);
					}
			  }
				else if(!distance.containsKey(neighborNode.node)) {
					q.add(neighborNode.node);
					int newDistance = distance.get(currNode) + neighborNode.cost;
					distance.put(neighborNode.node, newDistance);
				}
			}
		}
		
		for(Entry<String,Integer> d: distance.entrySet()) {
			 System.out.println( d.getKey() +":"+ d.getValue() );
		}
		
		
	}

	public static void main(String[] args) {
		BFSImpl4 graph = new BFSImpl4(5, 7);

		graph.addNode("A", Arrays.asList(new Node("B", 5), new Node("D", 16)));
		graph.addNode("B", Arrays.asList(new Node("D", 1), new Node("E", 3)));
		graph.addNode("C", Arrays.asList(new Node("A", 4), new Node("D", 7)));
		graph.addNode("D", Arrays.asList(new Node("E", 2)));
		graph.addNode("E", new ArrayList<Node>());
//		graph.printAdjList();

		graph.traverseFromSource("A");			

//		for(String key: graph.adjListMap.keySet()) {
//			System.out.println("Starting Node :: "+key);
//			graph.traverseFromSource(key);			
//		}
		
		

//  		graph.shortestReach(1,3);
	}
}
