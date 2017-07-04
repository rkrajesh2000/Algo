package Algo.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTravel {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2); 
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4); 
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6); 
		root.right.right = new TreeNode(7);
		System.out.println("Level order : ");
		assignTreeNode(root);	
	}
	
	private static void assignTreeNode(TreeNode root){
		
		Queue<LinkedList<TreeNode>> queue = new LinkedList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> innerQueue = new LinkedList<TreeNode>();
		innerQueue.add(root);
		queue.add(innerQueue);
		System.out.print(root.val + ", ");
		System.out.println();
		
		while(!queue.isEmpty()){
			
			innerQueue = new LinkedList<TreeNode>();
			
			for(TreeNode node : queue.poll()){
				if(node != null){					
				
					if(node.left != null){
						System.out.print(node.left.val + ", ");
						innerQueue.add(node.left);						
					}
					
					if(node.right != null){
						System.out.print(node.right.val + ", ");
						innerQueue.add(node.right);						
					}
				}
			}
			
			if(!innerQueue.isEmpty())				
				queue.add(innerQueue);
			
			System.out.println();
		}
	}
}
