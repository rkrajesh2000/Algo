package Algo.Test;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        System.out.print("Is Valid BST : " + isValidBST(root));
	}
	
	//Test Case: [10,5,15,null,null,6,20] and [2147483647]
    public static boolean isValidBST(TreeNode root)
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
}
