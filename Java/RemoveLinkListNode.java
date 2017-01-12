package Algo.Test;

public class RemoveLinkListNode {

	public static void main(String[] args) {
		ListNode obj = new ListNode(11);
        obj.appendToTail(21);
        obj.appendToTail(33);
        obj.appendToTail(41);
        obj.appendToTail(15);
        obj.appendToTail(26);
        obj.appendToTail(17);
        obj.appendToTail(28);
        obj.appendToTail(19);
        
        ListNode runner = obj;
        System.out.print("List Node Before delete : ");
    	while(runner != null){
    		System.out.print(runner.val + ",");  
    		runner = runner.next;
    	}
    	
    	int nodeToRemove = 5;
    	removeNthFromEnd(obj, nodeToRemove);
    	
        runner = obj;
        System.out.println("");
        System.out.print("List Node After deleting node# " + nodeToRemove + " : ");
    	while(runner != null){
    		System.out.print(runner.val + ",");   
    		runner = runner.next;
    	}
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null)
        {
            return head;
        }  
        
        ListNode p1 = head;
        ListNode p2 = head;

        int count2 = 0;

        while (p2.next != null)
        {
            p2 = p2.next;
            ++count2;
        }
        
        if(n==1 && count2 == 0)
            return null;
        else if (n > count2)
            return head.next;


        while (n < count2)
        {
            p1 = p1.next;
            --count2;
        }

        p1.next = p1.next.next;
        
        return head;
    }
}
