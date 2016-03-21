package AdjacencyMatrix;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
//import lis.LIS;
import stack.MyStack;
import queue.MyQueue;

public class Graph {

	int[][] graph;
	int vertices;
	
	/*				1___4
	 * 		  /	  \	
	 *			/ 		 5
	 *		0__2__|___6
	 * 		\		/
	 * 			3
	 */
	
	Graph() {
		this.graph =new int[][]{
				{0,1,1,1,0,0,0}, 
				{1,0,0,0,1,1,0},
				{1,0,0,0,0,0,1},
				{1,0,0,0,0,1,0},
				{0,1,0,0,0,0,0},
				{0,1,0,1,0,0,0}, 
				{0,0,1,0,0,0,0}};
		//this.graph =new int[][]{{0,1,1,1,1,1,1}, {1,0,1,1,1,1,1}, {1,1,0,1,1,1,1}, {1,1,1,0,1,1,1}, {1,1,1,1,0,1,1},{1,1,1,1,1,0,1}, {1,1,1,1,1,1,0}};
		this.vertices = graph[0].length;
	}
	
	public int vertices() {
		return vertices;
	}
	
	public ArrayList<Integer> connectedTo(int index){
		ArrayList<Integer>  neighbours = new ArrayList<Integer>();
		for(int i = 0 ; i < graph[index].length; i++)		
		{			
			if(graph[index][i] > 0)		
				neighbours.add(i);
		}
		return neighbours;
	}
	
	public List<Integer> iterativeDFS() {		
		boolean[] visited = new boolean[vertices];
		List<Integer> order = new ArrayList<Integer>();		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while (!stack.isEmpty())
		{
			int vertex = stack.pop();			
			if (!visited[vertex])
			{
				visited[vertex] = true;
				order.add(vertex);						
				for(int neighbour: connectedTo(vertex))
					stack.push(neighbour);
			}
		}
		return order;
	}
	
	public void recursiveDFS() {
		boolean[] visited = new boolean[vertices];
		this.recursiveDFS(visited,0);
	}
	public void recursiveDFS(boolean[] visited, int vertex) {
		visited[vertex] = true;
		System.out.print(vertex +", ");
		for(Integer neighbour: connectedTo(vertex)) {
			if(!visited[neighbour]) {
				recursiveDFS(visited,neighbour);
			}
		}
	}
	
	//please use the function bfs1
	@Deprecated
	public ArrayList<Integer> bfs() {
		ArrayList<Integer> order = new ArrayList<Integer>();
		MyQueue<Integer> queue = new MyQueue<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		queue.enqueue(0);
		set.add(0);
		order.add(0);
		while(!queue.isEmpty())
		{
			int vertex = queue.dequeue();
			for(Integer neighbour: connectedTo(vertex))
				if(!set.contains(neighbour))
				{
					set.add(neighbour);
					queue.enqueue(neighbour);
					order.add(neighbour);
				}
		}
		return order;
	}
	
	//BFS  using visited boolean array instead of using set
	public ArrayList<Integer> bfs1() {
		boolean[] visited = new boolean[vertices];
		ArrayList<Integer> order = new ArrayList<Integer>();		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		while(!queue.isEmpty()) {
			int vertex = queue.remove();
			if(!visited[vertex]) {
				visited[vertex] = true;
				order.add(vertex);
				for(Integer neighbour: connectedTo(vertex))
					queue.add(neighbour);
			}
		}
		return order;
	}
	public static void main(String[] args) {
		Graph newGraph = new Graph();

		System.out.print("Iterative DFS:"+newGraph.iterativeDFS());
		System.out.print("\nRecursive DFS:");newGraph.recursiveDFS();
		System.out.print("\nBFS: "+newGraph.bfs());		
		System.out.print("\nBFS by using other approach: "+newGraph.bfs1());
		//System.out.print(newGraph.connectedTo(6));
	}
}
