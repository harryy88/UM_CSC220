package lab11;


import java.util.HashSet;
import java.util.Set;

public class Node {
	boolean visited; 
	Set<Node> neighbors = new HashSet<Node>();
	Node cameFrom; 
	int row, col; 
	
	Node(int r, int c ){
		row = r; 
		col = c; 
		visited = false; 
		cameFrom = null; 
	}
}
