package Algo.Test;

public class ReverseListNodesInGroup {

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
        
        int nodeGroup = 3;
        ListNode runner = reverseKGroup(obj,nodeGroup);        
        
        System.out.print("Reverse List Node in group of " + nodeGroup + " : ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	}        
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
	    if(head==null||k==1)
	        return head;
	 
	    ListNode fake = new ListNode(0);
	    fake.next = head;
	    ListNode pre = fake;
	    int i=0;
	 
	    ListNode p = head;
	    while(p!=null){
	        i++;
	        if(i%k==0){
	            pre = reverse(pre, p.next);
	            p = pre.next;
	        }else{
	            p = p.next; 
	        }
	    }
	 
	    return fake.next; 
	}
	 
	/*
	 * 0->1->2->3->4->5->6
	 * |           |   
	 * pre        next
	 *
	 * after calling pre = reverse(pre, next)
	 * 
	 * 0->3->2->1->4->5->6
	 *          |  |
	 *          pre next 
	 */
	public static ListNode reverse(ListNode pre, ListNode next){
	    ListNode last = pre.next; // last = 1
	    ListNode curr = last.next; //curr = 2
	 
	    while(curr != next){
	        last.next = curr.next; // last.next = 3, 4
	        curr.next = pre.next; // curr.next = 1, 3
	        pre.next = curr; // pre.next = 2, 3
	        curr = last.next; // curr =3, 4
	    }
	 
	    return last; // last = 3
	}	
}
