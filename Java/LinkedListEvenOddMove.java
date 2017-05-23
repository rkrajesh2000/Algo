package Algo.Test;

public class LinkedListEvenOddMove {

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
        
        System.out.print("List Before Even and Odd move ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	} 
    	
    	runner = moveEvenAndOdd(obj);        

    	System.out.println();
        System.out.print("List After Even and Odd move ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	}

	}

	private static ListNode moveEvenAndOdd(ListNode head) {
	    if(head == null) 
	        return head;
	 
	    ListNode p1 = head;
	    ListNode p2 = head.next;
	    ListNode nextHeadNode = head.next;
	    
	    while(p2 != null){
	    	
	    		if(p2.next == null)
	    			break;
	    		
	            p1.next = p2.next;
	            p1 = p1.next;
	 
	            p2.next = p1.next;
	            p2 = p2.next;
	    }
	 
	    p1.next = p2;
	    p1.next = nextHeadNode;
	    
	    return head;
	}
}
