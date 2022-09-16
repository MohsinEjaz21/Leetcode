
// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
public class DFSImpl {

	private HashMap<Integer, Node> nodeLookup = new HashMap<>();

	class Node {
		private int id;
		LinkedList<Node> adjList = new LinkedList<>();

		private Node(int id) {
			this.id = id;
		}
	}

	private Node getNode(int id) {
		return nodeLookup.get(id);

	}

	public void addEdge(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);

		s.adjList.add(d);
	}

	public boolean hasPathDFS(int source, int destination) {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<>();
		return hasPathDFS(s, d, visited);
	}

	private boolean hasPathDFS(Node source , Node destination , HashSet<Integer> visited) {
		if(visited.contains(source.id)) {
			return false;
		};
		visited.add(source.id);
		if(source == destination) {
			return true;
		}
		for (Node child : source.adjList) {
			if(hasPathDFS(child, destination,visited)) {
				return true; 
			}
		}
		return false;
	}

}
// This code is contributed by Aakash Hasija
