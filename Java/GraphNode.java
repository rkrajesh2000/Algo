package Algo.Test;

import java.util.ArrayList;

public class GraphNode {
	 int val;
	 ArrayList<GraphNode> neighbors;
	 GraphNode(int v) { 
		 val = v; 
		 neighbors = new ArrayList<GraphNode>(); 
	 }
}
