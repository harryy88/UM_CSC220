package lab11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;


public class PathFinder {
	
	public static int height;
	public static int width; 
	public static char[][] card;
	public static Node[][] graph;
	public static Node start; 
	public static Node goal; 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			PathFinder.solveMaze("randomMaze.txt", "Cheryloput.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void solveMaze(String inputFile, String outputFile) throws IOException {
		addFile(inputFile);
		bfs(); //implements breath-first algorithm 
		makePath(); //appends shortest path to game card
		makeFile(outputFile); //outputs file

		
	}
	
	public static void makeFile(String output) throws IOException {

			
			PrintWriter file = new PrintWriter(new FileWriter(output));
			file.print(height);
			file.print(" ");
			file.println(width);
			for (int i = 0; i < height; ++i) {
				for (int j = 0; j < width; ++j) {
					file.print(card[i][j]);
				}
				file.println();
			}
			
			file.close();
		
		
	}
	
	public static void makePath() {
		Node c = goal.cameFrom; 
		while (c != null) {
			card[c.row][c.col] = '.'; 
			if (graph[c.row][c.col] == start) {
				card[c.row][c.col] = 'S';
			}
			c = c.cameFrom; 
		}
		
	}
	
	public static void bfs() {
		Queue<Node> q = new LinkedList<Node>();
		start.visited = true; 
		q.add(start);
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(curr.equals(goal)) {
				return; 
			}
			for(Node next : curr.neighbors) {
				if(!next.visited) {
					next.visited = true; 
					next.cameFrom = curr; 
					q.add(next);
				}
			}
		}
	}
	
	public static void findNeighbor(int x, int y, Node n) {
		if(x + 1 <= width && graph[x + 1][y] != null) {  //adds to a set of Nodes for each neighbor
			n.neighbors.add(graph[x + 1][y]);
			graph[x + 1][y].neighbors.add(n);
		}
		if(x - 1 >  0 && graph[x - 1][y] != null) {
			n.neighbors.add(graph[x - 1][y]);
			graph[x - 1][y].neighbors.add(n);
		}
		if(y + 1 <= height && graph[x][y + 1] != null) {
			n.neighbors.add(graph[x][y + 1]);
			graph[x][y + 1].neighbors.add(n);
		}
		if(y - 1 > 0 && graph[x][y - 1] != null) {
			n.neighbors.add(graph[x][y - 1]);
			graph[x][y - 1].neighbors.add(n);
		}
	}
	
	public static void addLine(String line, int count) {
		if (count >= 0 && count <= height) {
			for (int col = 0; col < width; ++col) {
				char ch = line.charAt(col);
				card[count][col] = ch;
				if (ch != 'X') {
					graph[count][col] = new Node(count, col);
					findNeighbor(count, col, graph[count][col]);
					if(ch == 'S') {
						start = graph[count][col];
					}
					else if(ch == 'G') {
						goal = graph[count][col];
					}	
				}	
			}
		}
	}
	
	public static void addFile(String fileName) throws IOException {
		
		BufferedReader reader = null;

		try {
		    File file = new File(fileName);
		    reader = new BufferedReader(new FileReader(file));
		    int count = 0; 
		    String line, firstLine = "";
		    
		    while ((line = reader.readLine()) != null) {
		    	if (count == 0) {
		    		 firstLine = line; 
		    		 String[] dim = firstLine.split(" ");
		    		 height = Integer.parseInt(dim[0]);
		    		 width = Integer.parseInt(dim[1]);
		    		 card = new char[height][width];
		    		 graph = new Node[height][width];
		    	}
		    	else {	
		    		addLine(line, count - 1);
		    	}
		    	
		    	++count; 
		    } 
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        reader.close();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}	
	}
}
