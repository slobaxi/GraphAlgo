package slobaxi.algorihms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import slobaxi.implementation.Graph;

public class BreadthFirstSearch {
	
	public static <T> boolean bfs(Graph<T> g,T source, T destination) {
		HashSet<T> visited = new HashSet<T>();
		Stack<T> stack = new Stack<T>();
		stack.add(source);
		visited.add(source);
		return bfs(g,source,destination,visited,stack);
	
	}
	
	private static  <T> boolean bfs(Graph<T> g,T source, T destination,HashSet<T> visited,Stack<T> stack) {
		if(destination==visited) {
			return true;
		}
		while(!stack.isEmpty()) {
			T pom =stack.pop();
			if(destination==pom) {
				return true;
			}
			List<T> neighb = new LinkedList<T>();
			neighb.addAll(g.getNeighbours(pom));
			for(T x:neighb) {
				if(!visited.contains(x)) {
					stack.push(x);
					visited.add(x);
				}
			}
		}
		return false;
	}

}
