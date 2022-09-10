import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjListImpl {

	private List<Integer> adj[];

	public GraphAdjListImpl(int vertices) {
		adj = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	public int minimumDistanceBFS(int source, int destination) {
		boolean visited[] = new boolean[adj.length];
		// parent tells which introduces what?
		int parent[] = new int[adj.length];
		// queue is used to maintain the nodes edges.
		Queue<Integer> q = new LinkedList<>();
		q.add(source);

		// initially source is not introduced so -1;
		parent[source] = -1;
		visited[source]=true;
		

		while (q.isEmpty()) {
			// pull out first element in queue;
			int current = q.poll();
			if (current == destination)
				break;
			
			// adj list will tell the neighbors of nodes;
			for(int neightbor: adj[current]) {
				if(!visited[neightbor]) {
					visited[neightbor] =true;
					q.add(neightbor);
					parent[neightbor] = current;
				}
			}
		}
		
		int current = destination;
		int distance =0;
		while(parent[current] != -1) {
			System.out.println(current+" =>> ");
			current = parent[current];
			distance++;
		}

		return distance;
	}

	public static void main(String[] args) {
		int v = 5;
		int e = 6;
		int src =0;
		int dest =3;
		int[][] edges = { {0,1}, {1,2}, {2,3}, {3,4}, {0,4},{2,4} };

		GraphAdjListImpl graph = new GraphAdjListImpl(v);
	
		for(int[] edge: edges) {
			int source = edge[0];
			int destination = edge[1];
			graph.addEdge(source, destination);
		}
		
		System.out.println("minimum distance :: " + graph.minimumDistanceBFS(src, dest));

	}
}
