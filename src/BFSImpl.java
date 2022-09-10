import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class BFSImpl {

	List<LinkedList<Integer>> adjList;
	int noOfvertex;

	public BFSImpl(int vertexSize) {
		noOfvertex = vertexSize;
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

	void traverseGraphBFS(int source) {

		//	Create Queue to track the adj nodes
		Queue<Integer> q = new LinkedList<>();

		// create the boolean of nodes size of initaly false
		boolean[] visited = new boolean[noOfvertex];

		// add source into queue
		// define source as visited

		q.add(source);

		visited[source] = true;
		
		// check wheter que is empty
		while(!q.isEmpty()) {
			
			// pick the first node of the queue
			int fNode = q.poll();
			System.out.print(source+" ");

			// find the adjList of the node
			Iterator<Integer> adjIterator = adjList.get(fNode).iterator();
			while (adjIterator.hasNext()) {
				if(!visited[fNode]) {
					visited[fNode]= true;
					q.add(adjIterator.next());
				}
			}
		}

	}

	public static void main(String[] args) {
		BFSImpl graph = new BFSImpl(5);

		graph.addEdgesBothWays(0, 1);
		graph.addEdgesBothWays(1, 2);
		graph.addEdgesBothWays(2, 3);
		graph.addEdgesBothWays(3, 4);
		graph.addEdgesBothWays(0, 4);
		graph.addEdgesBothWays(2, 4);

		graph.traverseGraphBFS(0);

	}

}
