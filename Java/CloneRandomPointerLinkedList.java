package Algo.Test;

import java.util.*;

//Clone a linked list with next and random pointer 
public class CloneRandomPointerLinkedList {

		  
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		ListNode n1 = node;
		node.appendToTail(2);
		ListNode n2 = n1.next;
		node.appendToTail(3);
		ListNode n3 = n2.next;
		node.appendToTail(4);
		ListNode n4 = n3.next;
		node.appendToTail(5);
		ListNode n5 = n4.next;
		n1.random = n3;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n2;
		
		System.out.print("Original Node  : ");
		DisplayNode(node);	
		System.out.println();
		System.out.print("CopyWithBuffer : ");
		DisplayNode(copyRandomListWithBuffer(node));
		System.out.println();
		System.out.print("CopyWithNoBufer: ");
		DisplayNode(copyRandomList(node));		
	}

	private static void DisplayNode(ListNode p){
		while(p != null){
			
			System.out.print("(N=" + p.val);
			
			if(p.random != null)
				System.out.print(",R =" + p.random.val);
			
			System.out.print(") ");
			
			p = p.next;
		}		
	}	

	private static ListNode copyRandomList(ListNode head) {
		 
		if (head == null)
			return null;
	 
		ListNode p = head;

		// copy every node and insert to list
		while (p != null) {
			ListNode copy = new ListNode(p.val);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}
	 
		// copy random pointer for each new node
		p = head;
		
//		System.out.print("head =");
//		DisplayNode(head);
//		System.out.println();
		
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}
	 
		// break list to two
		p = head;
		ListNode newHead = head.next;
		
		while(p != null && p.next != null){
			ListNode temp = p.next;
		    p.next = temp.next;
		    p = temp;
		}
	 
		return newHead;
	}
	
	private static ListNode copyRandomListWithBuffer(ListNode head) {
		if (head == null)
			return null;
		HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
		ListNode newHead = new ListNode(head.val);
	 
		ListNode p = head;
		ListNode q = newHead;
		map.put(head, newHead);
	 
		p = p.next;
		while (p != null) {
			ListNode temp = new ListNode(p.val);
			map.put(p, temp);
			q.next = temp;
			q = temp;
			p = p.next;
		}
	 
		p = head;
		q = newHead;
		while (p != null) {
			if (p.random != null)
				q.random = map.get(p.random);
			else
				q.random = null;
	 
			p = p.next;
			q = q.next;
		}
	 
		return newHead;
	}		
}
