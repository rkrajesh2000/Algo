package Algo.Test;

public class ReverseLinkList {
	public static void main(String[] args) {
		
		ListNode obj = new ListNode(1);
        obj.appendToTail(2);
        obj.appendToTail(3);
        obj.appendToTail(4);
        obj.appendToTail(5);
        obj.appendToTail(6);
        obj.appendToTail(7);
        obj.appendToTail(8);
        obj.appendToTail(9);
        obj.appendToTail(10);
        obj.appendToTail(11);
        
        ListNode runner = obj;
        
        System.out.print("List Before Reverse ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	} 
    	
    	runner = reverseListIterative(obj);        

    	System.out.println();
        System.out.print("List After Iterative Reverse ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	}
    	
		ListNode obj2 = new ListNode(1);
		obj2.appendToTail(2);
		obj2.appendToTail(3);
		obj2.appendToTail(4);
		obj2.appendToTail(5);
		runner = obj2;
		
    	System.out.println();
        System.out.print("List Before In Between Reverse ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	} 
    	
    	runner = reverseBetween(obj2, 2, 4);
    	
    	System.out.println();
        System.out.print("List After In Between Reverse ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	} 
    	
    	runner = reverseListRecursive(obj2);
    	System.out.println();
        System.out.print("List After Recursive Reverse ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	}    	
	}
	
	private static ListNode reverseListIterative(ListNode head) {
	    if(head==null||head.next==null)
	        return head;
	 
	    ListNode p1 = head;
	    ListNode p2 = p1.next;
	    head.next = null;
	    
	    while(p1!=null && p2!=null){
	        ListNode temp = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = temp;
	    }

	    return p1;
	}
	
	private static ListNode reverseListRecursive(ListNode head) {
	    if(head==null || head.next == null)
	        return head;
	 
	    //get second node    
	    ListNode second = head.next;
	    //set first's next to be null
	    head.next = null;
	 
	    ListNode rest = reverseListRecursive(second);
	    second.next = head;
	 
	    return rest;
	}	
	
	private static ListNode reverseBetween(ListNode head, int m, int n) {
	    if(m==n) return head;
	 
	    ListNode prev = null;//track (m-1)th node
	    ListNode first = new ListNode(0);//first's next points to mth
	    ListNode second = new ListNode(0);//second's next points to (n+1)th	 
	    int i=0;
	    ListNode p = head;
	    
	    while(p!=null){
	        i++;
	        if(i==m-1){
	            prev = p;
	        }
	 
	        if(i==m){
	            first.next = p;
	        }
	 
	        if(i==n){
	            second.next = p.next;
	            p.next = null;
	        }
	 
	        p= p.next;
	    }
	    
	    if(first.next == null)
	        return head;
	 
	    // reverse list [m, n]    
	    ListNode p1 = first.next;
	    ListNode p2 = p1.next;    	
	    p1.next = second.next;
	 
	    while(p1!=null && p2!=null){
	        ListNode t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = t;	        
	    }
	 
	    //connect to previous part
	    if(prev!=null)
	        prev.next = p1;
	    else
	        return p1;	 

	    return head;
	}	
}
