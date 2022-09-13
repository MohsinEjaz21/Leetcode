import java.util.*;

// A class to store a graph edge

// A class to represent a graph object
class Graph {
	// A list of lists to represent an adjacency list

	static class Edge {
		int source, dest, weight;

		public Edge(int source, int dest, int weight) {
			this.source = source;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.format("Edge [source=%s, dest=%s, weight=%s]", source, dest, weight);
		}

	}

	// A class to store a heap node
	static class Node {
		int vertex, weight;

		public Node(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return String.format("Node [vertex=%s, weight=%s]", vertex, weight);
		}

	}

	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge edge : edges) {
			adjList.get(edge.source).add(edge);
		}
	}
}

public class Dijesktra {
	private static void getRoute(int[] prev, int i, List<Integer> route) {
		if (i >= 0) {
			getRoute(prev, prev[i], route);
			route.add(i);
		}
	}

	// Run Dijkstra’s algorithm on a given graph
	public static void findShortestPaths(Graph graph, int source, int n) {
		// create a min-heap and push source node having distance 0
		PriorityQueue<Graph.Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		pq.add(new Graph.Node(source, 0));

		// set initial distance from the source to `v` as infinity
		List<Integer> distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

		// distance from the source to itself is zero
		distance.set(source, 0);

		// boolean array to track vertices for which minimum
		// cost is already found
		boolean[] visited = new boolean[n];
		visited[source] = true;

		// stores predecessor of a vertex (to a print path)
		int[] prev = new int[n];
		prev[source] = -1;

		// run till min-heap is empty
		while (!pq.isEmpty()) {
			// Remove and return the best vertex
			Graph.Node node = pq.poll();

			// get the vertex number
			int parentNode = node.vertex;

			// do for each neighbor `v` of `u`
			for (Graph.Edge edge : graph.adjList.get(parentNode)) {
				int adjVertex = edge.dest;
				int newDistance = distance.get(parentNode) + edge.weight;
				int prevDistance = distance.get(adjVertex);

				// Relaxation step
				if (!visited[adjVertex] && newDistance < prevDistance) {
					distance.set(adjVertex, newDistance);
					prev[adjVertex] = parentNode;
					pq.add(new Graph.Node(adjVertex, newDistance));
				}
			}

			// mark vertex `u` as done so it will not get picked up again
			visited[parentNode] = true;
		}

		List<Integer> route = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (i != source && distance.get(i) != Integer.MAX_VALUE) {
				getRoute(prev, i, route);
				System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n", source, i, distance.get(i), route);
				route.clear();
			}
		}
	}

	public static void main(String[] args) {
		// initialize edges as per the above diagram
		// (u, v, w) represent edge from vertex `u` to vertex `v` having weight `w`
		List<Graph.Edge> edges = Arrays.asList(new Graph.Edge(0, 1, 10), new Graph.Edge(0, 4, 3), new Graph.Edge(1, 2, 2),
		    new Graph.Edge(1, 4, 4), new Graph.Edge(2, 3, 9), new Graph.Edge(3, 2, 7), new Graph.Edge(4, 1, 1),
		    new Graph.Edge(4, 2, 8), new Graph.Edge(4, 3, 2));

		// total number of nodes in the graph (labelled from 0 to 4)
		int n = 5;

		// construct graph
		Graph graph = new Graph(edges, n);
		findShortestPaths(graph, 0, n);

		// run the Dijkstra’s algorithm from every node
//		for (int source = 0; source < n; source++) {
//			findShortestPaths(graph, source, n);
//		}
	}
}