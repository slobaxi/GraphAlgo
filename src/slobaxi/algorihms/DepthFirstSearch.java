package slobaxi.algorihms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import slobaxi.implementation.Graph;

public class DepthFirstSearch {
	
	public static <T> boolean dfs(Graph<T> g,T source, T destination) {
		HashSet<T> visited = new HashSet<T>();
		visited.add(source);
		return dfs(g,source,destination,visited);
	
	}
	
	private static <T> boolean dfs(Graph<T> g,T source, T destination,HashSet<T> visited ) {
		if(source==destination) {
			return true;
		}
		List<T> neigh = new LinkedList<T>();
		neigh.addAll(g.getNeighbours(source));
		for(T x:neigh) {
			if(!visited.contains(x)) {
				visited.add(x);
				return dfs(g,x,destination,visited);
			}
		}
		return false;
	}

}
