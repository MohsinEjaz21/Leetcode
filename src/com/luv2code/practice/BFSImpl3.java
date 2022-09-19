package com.luv2code.practice;
import java.util.*;
import java.util.LinkedList;
public class BFSImpl3 {
    /** Edge weight **/
    private static int EDGE_DISTANCE;
    
    /** Track distance to 'start' node **/
    public int[] distance;
    /** Graph where index is 0-indexed node ID and each element is the set of neighboring nodes. **/
    public ArrayList<HashSet<Integer>> graph;
    /** Starting node number for BFS, default Java initialization is to node 0 **/
    public int start;
    
    public BFSImpl3(int n, int edgeWeight) {
        EDGE_DISTANCE = edgeWeight;
        
        this.distance = new int[n];
        Arrays.fill(distance, -1);
        
        this.graph = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++) {
            this.graph.add(new HashSet<Integer>());
        }
    }
    
    class Edge{
    	int node;
    	int cost;
			public Edge(int cost, int node) {
				super();
				this.cost = cost;
				this.node = node;
			}
    }
    
  	void addEdgesBothWays(int source, int destination) {
  		graph.get(source).add(destination);
  		graph.get(destination).add(source);
  	}

    
    public void shortestReach(int s, int d) {
        
        this.start = s;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        distance[start] = 0;
        
        // BFS from start
        while (queue.size() > 0) {
            int u = queue.poll();
            
            // for each unvisited neighbor of the current node
            for (int v : graph.get(u)) {
                
                // Add unvisited neighboring nodes to queue to check its neighbors at next level of the search, set distance
                if (distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[u] + EDGE_DISTANCE;
                }
            }
        }
        
        for (int i : distance) {
            if (i != 0) {
                System.out.print(i + " ");
            } 
        }
        
        System.out.println();
        
        // Just resets all distances to -1 in the event that this method is ever called multiple times for some different 's'.
        Arrays.fill(distance, -1);
    }
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
  		BFSImpl3 graph = new BFSImpl3(5,6);

  		graph.addEdgesBothWays(0, 1);
  		graph.addEdgesBothWays(1, 2);
  		graph.addEdgesBothWays(2, 3);
  		graph.addEdgesBothWays(3, 4);
  		graph.addEdgesBothWays(0, 4);
  		graph.addEdgesBothWays(2, 4);

  		graph.shortestReach(1,3);
    }
}
