package Algo.Test;

public class ListNode {

	int val;
	ListNode next;
	public ListNode(int x) { val = x; }	
	
    public void appendToTail(int d)
    {
    	ListNode end = new ListNode(d);
    	ListNode n = this;
        while ((n.next != null))
        {
            n = n.next;
        }

        n.next = end;
    }	
}
