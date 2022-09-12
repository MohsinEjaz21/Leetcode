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
	
	void traverseFromSource() {
		
	}

	public static void main(String[] args) {
		BFSImpl4 graph = new BFSImpl4(5, 7);

		graph.addNode("A", Arrays.asList(new Node("B", 5), new Node("D", 16)));
		graph.addNode("B", Arrays.asList(new Node("D", 1), new Node("E", 3)));
		graph.addNode("C", Arrays.asList(new Node("A", 4), new Node("D", 7)));
		graph.addNode("D", Arrays.asList(new Node("E", 2)));
		graph.addNode("E", new ArrayList<Node>());
		graph.printAdjList();
	  
		
		

//  		graph.shortestReach(1,3);
	}
}
