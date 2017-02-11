package Algo.Test;

import java.util.*;

public class GraphCloning {
	public static void main(String[] args){
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		node0.neighbors.add(node1);
		GraphNode node2 = new GraphNode(2);
		node0.neighbors.add(node2);
		GraphNode node3 = new GraphNode(3);
		node1.neighbors.add(node3);
		node3.neighbors.add(node2);
		GraphNode node4 = new GraphNode(4);
		node3.neighbors.add(node4);
		GraphNode node5 = new GraphNode(5);
		node3.neighbors.add(node5);
				
		GraphNode root = node0;
		displayGraph(root);
		
		
		System.out.println("");
		System.out.println("After Cloning");
		
		GraphNode head = cloneGraph(node0);
		displayGraph(head);
	}
	
	private static void displayGraph(GraphNode node){
		
		if(node == null)
			return;
		System.out.print(node.val);
		System.out.print("-->");
		
		if(node.neighbors != null && node.neighbors.size() > 0){
			displayNeighbors(node.neighbors);
			System.out.println("");
			for(GraphNode n : node.neighbors)
				displayGraph(n);
		}
		else
			System.out.println("");
	}
	
	private static void displayNeighbors(ArrayList<GraphNode> nodeList){
		
		for(GraphNode node : nodeList)
			System.out.print(node.val + ", ");
	}
	
	//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
	private static GraphNode cloneGraph(GraphNode node){
		
		if(node == null)
			return node;
		
		HashMap<GraphNode,GraphNode> map = new HashMap<GraphNode,GraphNode>();
		LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
		GraphNode head = new GraphNode(node.val);
		
		map.put(node, head); //Map key is current node and values are new cloned or created node.
		queue.push(node);
		
		while(!queue.isEmpty()){
			
			GraphNode currNode = queue.pop();
			ArrayList<GraphNode> currNbrList = currNode.neighbors;
			
			if(currNbrList == null)
				continue;			
			
			for(GraphNode eachNbrNode: currNbrList){
				
				if(!map.containsKey(eachNbrNode)){
					
					GraphNode newNode = new GraphNode(eachNbrNode.val);
					map.put(eachNbrNode, newNode);
					//Get the value (previously cloned node) of current node and add newly created (cloned) node as neighbor. 
					map.get(currNode).neighbors.add(newNode);  
					queue.push(eachNbrNode);					
				}
				else{
					
					GraphNode prevClonedNode = map.get(eachNbrNode); // Get the previously cloned node value
					map.get(currNode).neighbors.add(prevClonedNode); // Get the previously cloned node value of current node and add as neighbor
				}
			}
		}
		
		return head;
	}
}
