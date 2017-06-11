package ch02.linkedlist;

import java.util.Deque;
import java.util.LinkedList;

import ch01.arraysandstrings.LinkedListNode;

public class Palindrome {
	// reverse a linked list array
	LinkedListNode reverse(LinkedListNode node) {
		LinkedListNode prev=null, cur=node, next;
		while(cur != null) {
			next = cur.next;
			
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	
	boolean ifPalindrome(LinkedListNode node) {
		LinkedListNode slow = node, fast = node;
		Deque<Integer> stack = new LinkedList<Integer>();
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// empty node or only one node
		if(slow == null) {
			return true;
		}
		
		// if even
		if(fast == null) {
			if(stack.pop() != slow.data) {
				return false;
			}
		}
		
		slow = slow.next;
		while(slow != null) {
			if(stack.pop() != slow.data) {
				return false;
			}
			slow = slow.next; 
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String num1 = "1234234321";
		LinkedListNode l1 = null, tail1 = null;
		Palindrome pld = new Palindrome();
		char[] num1char = num1.toCharArray();
		
		for(char c : num1char) {
			if(l1 == null) {
				l1 = new LinkedListNode(c-'0');
				tail1 = l1;
			} else {
				tail1.next = new LinkedListNode(c-'0');
				tail1 = tail1.next;
			}
			
		}
		
		LinkedListNode.printMe(l1);
		
		LinkedListNode reversedL1 = pld.reverse(l1);
		
		LinkedListNode.printMe(reversedL1);
//		LinkedListNode.printMe(l1);
		System.out.println(pld.ifPalindrome(reversedL1));
	}
	
}
