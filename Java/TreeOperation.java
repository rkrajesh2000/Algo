package Algo.Test;

public class TreeOperation {

	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.println("Is Valid BST isValidBST() : " + isValidBST(root));
        System.out.println("Minimum depth of tree minDepth() : " + minDepth(root));
        System.out.println("Is balance tree isBalanced() : " + isBalanced(root));
        System.out.println("maxPathSumInTree() : " + maxPathSumInTree(root));
        System.out.println("SumRootToLeafNumbers() : " + sumRootToLeafNumbers(root));
        
        TreeNode expressionRoot = new TreeNode("*");
        expressionRoot.left = new TreeNode("+");
        expressionRoot.right = new TreeNode("-");
        expressionRoot.left.left = new TreeNode("5");
        expressionRoot.left.right = new TreeNode("/");
        expressionRoot.left.right.left = new TreeNode("6");
        expressionRoot.left.right.right = new TreeNode("3");
        expressionRoot.right.left = new TreeNode("7");
        expressionRoot.right.right = new TreeNode("8");        
        System.out.println("expressionTree() : " + expressionTree(expressionRoot));
        
        
	}
	
	//Test Case: [10,5,15,null,null,6,20] and [2147483647]
    private static boolean isValidBST(TreeNode root)
    {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, long min, long max)
    {
        if (root == null)
            return true;

        if (root.val <= min || root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    } 
    
    /*
     * 111
     * Minimum Depth of Binary Tree
     */
    private static int minDepth(TreeNode root) {
    	
        if (root == null)        
            return 0;
            
        if (root.left == null)  
            return 1 + minDepth(root.right);
        
         if (root.right == null)  
            return 1 + minDepth(root.left);
        
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));        
    }
    
    /*
     * 110
     * Balanced Binary Tree
     */
    private static boolean isBalanced(TreeNode root) {
        
        if(root ==null) 
        	return true;
        
        return (
        		Math.abs(maxDepth(root.left) - maxDepth(root.right))) <= 1 
        		&& isBalanced(root.left) 
        		&& isBalanced(root.right
        		) ;
    }
    
    private static int maxDepth(TreeNode root)
    {
        if (root == null)        
            return 0;
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }  
    
    private static String expressionTree(TreeNode root){
    	
    	if(root == null)
    		return "";
    	
    	if(root.left == null && root.right == null)
    		return root.value;
    	
    	return "(" + expressionTree(root.left) + root.value + expressionTree(root.right) + ")";
    }
    
    /* 124
     * Given a binary tree, find the maximum path sum.
		For this problem, a path is defined as any sequence of nodes from some starting node to 
		any node in the tree along the parent-child connections. The path must contain at least one node 
		and does not need to go through the root. For example: Given the below binary tree,
	       1
	      / \
	     2   3
		Return 6.
     */

    private static int maxPathSumInTree(TreeNode root) {
        
        if(root == null)
            return 0;
        
        int[] maxSum = new int[]{root.val};
        helperPathSum(root, maxSum);
        return maxSum[0];
    }
    
    private static int helperPathSum(TreeNode root, int[] maxSum){
        
        if(root == null)
            return 0;
        
        int left = Math.max(helperPathSum(root.left,maxSum), 0);
        int right = Math.max(helperPathSum(root.right, maxSum), 0);
        maxSum[0] = Math.max(maxSum[0], root.val + left + right);
        return root.val + Math.max(left, right);        
    }
    
    /* 129
     * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
		An example is the root-to-leaf path 1->2->3 which represents the number 123.
		Find the total sum of all root-to-leaf numbers.
		For example,		
		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.		
		Return the sum = 12 + 13 = 25.
     */
    private static int sumRootToLeafNumbers(TreeNode root) {
        
        if(root == null)
            return 0;

        return helperSumRootToLeaf(root, 0);
        
    }
    
    private static int  helperSumRootToLeaf(TreeNode root, int val){
        
        if(root == null)
            return 0;
        
        int curVal = val * 10 + root.val;
        
        if(root.left == null && root.right == null )
        	return curVal;
                	
        return helperSumRootToLeaf(root.left, curVal) + helperSumRootToLeaf(root.right, curVal);     
    }    
}
