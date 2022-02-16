package slobaxi.implementation;

import slobaxi.algorihms.BreadthFirstSearch;
import slobaxi.algorihms.DepthFirstSearch;

public class MainTest {
	
	public static void main(String args[]) {
		Graph g = new Graph();
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(4, 5);
		g.addEdge(4, 3);
		g.addEdge(5, 3);
		System.out.println(DepthFirstSearch.dfs(g, 5, 1));
		System.out.println(g);
		AdjacencyMatrix am = new AdjacencyMatrix(g);
		System.out.println(am);		
		System.out.println(BreadthFirstSearch.bfs(g, 5, 1));
	}

}
