package Algo.Test;

public class RecoveryBinarySearchTree {

	static TreeNode first;
	static TreeNode second; 
	static TreeNode pre;
    
	public static void main(String[] args) {
/*        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7); */ 
		
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1); 
        
        System.out.print("Binary Search Tree Before Recovery : ");
        displayInOrder(root);
        System.out.println("");
        recoverTree(root);
        System.out.print("Binary Search Tree After Recovery : ");
        displayInOrder(root);        
	}
	
	public static void displayInOrder(TreeNode root){
		if(root != null){		
			displayInOrder(root.left);
			System.out.print(root.val + ", ");
	        displayInOrder(root.right);	
		}
	}
	
	// Test Case : [3,null,2,null,1]
    public static void recoverTree(TreeNode root) {
        if(root==null)
            return;
 
        recoverInOrder(root);
        if(second!=null && first !=null){
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
    }
    
    private static void recoverInOrder(TreeNode root) {
        if(root==null)
            return;
 
        recoverInOrder(root.left);
 
        if(pre==null){
            pre=root;
        }else{
            if(root.val<pre.val){
                if(first==null){
                    first=pre;
                }
 
                second=root;
            }
            pre=root;
        }
 
        recoverInOrder(root.right);
    }
}
