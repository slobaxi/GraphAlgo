import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	
	//vertex with it's list of neighbours 
	private Map<T,List<T>> map = new HashMap<>();
	private boolean directed=false;
	
		
	public void addVertex(T vertex) {
		map.put(vertex, new LinkedList<T>());
	}
	public void addEdge(T source,T destination) {
		
		if (!map.containsKey(source))   
			addVertex(source); 
		
		if (!map.containsKey(destination))   
			addVertex(destination);  
		
		map.get(source).add(destination); 
		if (directed)   
			map.get(destination).add(source);    
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
