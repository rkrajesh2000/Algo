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
		
		
		System.out.print("By treePathSumDFS(): Tree Nodes has path to add up to number " + sumNum + " : ");	
        for (List<Integer> list : treePathSumDFS(root,sumNum)) {
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
 
            if(curr.left == null && curr.right == null && sumValue==sum){
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.val);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.val);
            }
        }
 
        return false;
    }
	
	private static List<List<Integer>> treePathSumDFS(TreeNode root, int sum) {
		
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root == null) 
	        return result;
	 
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(root.val);
	    dfs(root, sum-root.val, result, list);
	    return result;
	}
	 
	private static void dfs(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list){
	    if(node.left==null && node.right==null && sum==0){
	        result.add(new ArrayList<Integer>(list));
	    }
	 
	    //Search left path
	    if(node.left != null){
	        list.add(node.left.val);
	        dfs(node.left, sum-node.left.val, result, list);
	        list.remove(list.size()-1);
	    }
	 
	  //Search right path
	    if(node.right!=null){
	        list.add(node.right.val);
	        dfs(node.right, sum-node.right.val, result, list);
	        list.remove(list.size()-1);
	    }
	}	
}
