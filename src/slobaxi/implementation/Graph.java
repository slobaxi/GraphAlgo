package slobaxi.implementation;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	
	//vertex with it's list of neighbours 
	private Map<T,List<T>> map = new HashMap<>();
	private boolean directed;
	
	//Constructors
	public Graph() {
		this.directed=false;
	}
	
	public Graph(boolean directed) {
		this.directed=directed;
	}
	
	//Basic methods for every Graph	
	public void addVertex(T vertex) {
		map.put(vertex, new LinkedList<T>());
	}
	public boolean addEdge(T source,T destination) {
		
		if (!map.containsKey(source))   
			addVertex(source); 
		
		if (!map.containsKey(destination))   
			addVertex(destination);  
		if(map.get(source).contains(destination)) {
			return false;
		}
		map.get(source).add(destination); 
		if (!directed)   
			map.get(destination).add(source);    
		return true;
	}
		
	public int countVertices() {
		return map.keySet().size();
	}
	public int countEdges() {
		int sum=0;
		for(List<T> edges :map.values()) {
			sum+=edges.size();
		}
		return directed ? sum:sum/2;
	}
	public boolean containsEdge(T vertex1,T vertex2) {	
		if(map.get(vertex1).contains(vertex2)) {
			return true;
		}
		return false;		
	}
	//Something like getters 
	public Collection<T> getVertices() {
		return map.keySet();
	}
	public boolean isDirected() {
		return directed;
	}
	
	//toString
	@Override
	public String toString() {   
		StringBuilder vertex = new StringBuilder("Vertices: ");   
		StringBuilder edges = new StringBuilder("Edges: ");  
		for (T v : map.keySet()) {   
			vertex.append(v.toString() + ", ");   
		 
			for (T w : map.get(v)){   
				edges.append("["+v.toString()+ "-"+w.toString() + "], ");   
			}      
		}
		//removing last ","
		if(vertex.charAt(vertex.length()-2)==',')
			vertex.deleteCharAt(vertex.length()-2);
		if(edges.charAt(edges.length()-2)==',')
			edges.deleteCharAt(edges.length()-2);
		
		return (vertex.toString()+"\n"+edges.toString());   
	}   
}
