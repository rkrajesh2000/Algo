package Algo.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sun.misc.Queue;

public class TreePathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.right = new TreeNode(1);
		
		int sumNum = 22;
		if(hasPathSumDFS(root,sumNum))
			System.out.println("By hasPathSumDFS(): Tree Node has path to add number " + sumNum);
		else
			System.out.println("By hasPathSumDFS(): Tree Node doesn't have path to add number " + sumNum);
		
		if(hasPathSumBFS(root,sumNum))
			System.out.println("By hasPathSumBFS(): Tree Node has path to add number " + sumNum);
		else
			System.out.println("By hasPathSumBFS(): Tree Node doesn't have path to add number " + sumNum);
		
		
		System.out.print("By treePathSumListDFS(): Tree Nodes has path to add up to number " + sumNum + " : ");	
        for (List<Integer> list : treePathSumListDFS(root,sumNum)) {
        	System.out.print("[");
        	
        	int counter = 0;
        	for(int val : list ){
        		System.out.print(val);
        		
        		++counter;
        		if(counter < list.size())
        			System.out.print(",");
        	}
        	
        	System.out.print("]");
        }
	}

	/* 112
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up 
	 * all the values along the path equals the given sum.
		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 */
	private static boolean hasPathSumDFS(TreeNode root, int sum) {
		
		if (root == null)
			return false;
		
		if (root.val == sum && (root.left == null && root.right == null))
			return true;
	 
		return hasPathSumDFS(root.left, sum - root.val)
				|| hasPathSumDFS(root.right, sum - root.val);
	}
	
	private static boolean hasPathSumBFS(TreeNode root, int sum) {
        if(root == null) return false;
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.val);
       
        while(!nodes.isEmpty()){
        	
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();        	
 
            if(curr.left == null && curr.right == null && sumValue == sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }
        }
 
        return false;
    }
	
	private static List<LinkedList<Integer>> treePathSumListDFS(TreeNode root, int sum) {
		
	    List<LinkedList<Integer>> result = new ArrayList<>();
	    if(root == null) 
	        return result;
	 
	    LinkedList<Integer> list = new LinkedList<>();
	    list.add(root.val);
	    dfs(root, sum-root.val, result, list);
	    return result;
	}
	 
	private static void dfs(TreeNode node, int sum, List<LinkedList<Integer>> result, LinkedList<Integer> list){
	    if(node.left==null && node.right==null && sum==0){
	        result.add(new LinkedList<Integer>(list));
	    }
	 
	    //Search left path
	    if(node.left != null){
	        list.add(node.left.val);
	        dfs(node.left, sum - node.left.val, result, list);
	        list.removeLast();
	    }
	 
	  //Search right path
	    if(node.right!=null){
	        list.add(node.right.val);
	        dfs(node.right, sum - node.right.val, result, list);
	        list.removeLast();
	    }
	}	
}
