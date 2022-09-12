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
	
	 void traverseFromSource(String startNode, String endNode) {
		Queue<String> q = new LinkedList<>();
		HashMap<String, Integer> distance = new HashMap<>();
		HashMap<String, String> path = new HashMap<>();
		StringBuilder pathBuilder = new StringBuilder();
		q.add(startNode);
		distance.put(startNode, 0);
		path.put(startNode,startNode);
    
    
		while(!q.isEmpty()) {
			System.out.println("QUEUE :: "+q);

			String currNode = q.poll();
//		  pathBuilder = new StringBuilder();
//			pathBuilder.append(currNode);

//			System.out.println("currNode :: "+currNode);
			List<Node> adjList = adjListMap.get(currNode);			

			for(Node neighborNode : adjList) {

				if(distance.containsKey(neighborNode.node)) {
//					System.out.println("currNode :: "+currNode);
//					System.out.println("neighbourNode :: "+neighborNode.node);

					int newDistance = distance.get(currNode) + neighborNode.cost;
					Integer prevDistance =  distance.get(neighborNode.node);
					if(prevDistance != null && newDistance < prevDistance) {
						distance.put(neighborNode.node, newDistance);
						pathBuilder.append(currNode);
					}

			  }
				else if(!distance.containsKey(neighborNode.node)) {
					
//					System.out.println("=> currNode :: "+currNode);
//					System.out.println("=> neighbourNode :: "+neighborNode.node);

					q.add(neighborNode.node);
					int newDistance = distance.get(currNode) + neighborNode.cost;
					distance.put(neighborNode.node, newDistance);
				}
				
//				pathBuilder.append(path.get(currNode));


			}
			
		}
		

		
		 System.out.println("path :: "+pathBuilder.toString());
		 System.out.println(distance);

//		for(Entry<String,Integer> d: distance.entrySet()) {
//			 System.out.println( d.getKey() +":"+ d.getValue()+" "+ path.get(d.getKey()) );
//		}
		
		
	}

	public static void main(String[] args) {
		BFSImpl4 graph = new BFSImpl4(5, 7);

		graph.addNode("A", Arrays.asList(new Node("B", 5), new Node("D", 3)));
		graph.addNode("B", Arrays.asList(new Node("D", 1), new Node("E", 3)));
		graph.addNode("C", Arrays.asList(new Node("A", 4), new Node("D", 7)));
		graph.addNode("D", Arrays.asList(new Node("E", 6)));
		graph.addNode("E", new ArrayList<Node>());
//		graph.printAdjList();

		graph.traverseFromSource("A", "D");			

//		for(String key: graph.adjListMap.keySet()) {
//			System.out.println("Starting Node :: "+key);
//			graph.traverseFromSource(key);			
//		}
		
		

//  		graph.shortestReach(1,3);
	}
}
