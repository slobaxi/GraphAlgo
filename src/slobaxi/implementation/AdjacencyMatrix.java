package slobaxi.implementation;

import java.util.ArrayList;

public class AdjacencyMatrix<T> {
	
	private int[][] adjacencyMatrix;
	private ArrayList<T> vertices= new ArrayList<T>();
	private boolean directed;
	private boolean loop;
	
	public AdjacencyMatrix(Graph<T> g) {
		adjacencyMatrix = new int[g.countVertices()][g.countVertices()];
		vertices.addAll(g.getVertices());
		directed = g.isDirected(); 
		
		for(int i=0;i<g.countVertices();i++) {
			for(int j=0;j<g.countVertices();j++) {
				if(g.containsEdge(vertices.get(i), vertices.get(j))) {
					adjacencyMatrix[i][j]=1;
				}
			}
		}		
	}
	public String toString() {
		if (adjacencyMatrix == null) {
		    return null;
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < adjacencyMatrix.length; i++) {
			sb.append("|");		
			for(int j=0;j<adjacencyMatrix.length;j++) {
				 
				 sb.append(" "+(adjacencyMatrix[i][j]));
			}
			sb.append(" ");
			sb.append("|");
			sb.append("\n");
		}
		return sb.toString();
	}
	
}
