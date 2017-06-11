package ch02.linkedlist;

import ch01.arraysandstrings.LinkedListNode;

class SumInfo {
	LinkedListNode sum = null;
	int carry = 0;
}
public class AddNumber {
	// reversed
	LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
		if(l1 == null & l2 == null &  carry == 0) {
			return null;
		}
		
		LinkedListNode result = new LinkedListNode(0);
		
		int value = carry;
		if(l1 != null) {
			value += l1.data;
		}
		if(l2 != null) {
			value += l2.data;
		}
		
		result.data = value %10;
		
		if(l1 != null || l2 != null) {
			LinkedListNode more = addLists(l1 == null ? null:l1.next, l2 == null ? null : l2.next, value >= 10 ? 1:0);
			result.next = more;
		}
		
		return result;
	}
	
	// forward
	LinkedListNode addListsForward(LinkedListNode l1, LinkedListNode l2) {
		// Find length
		int len1 = length(l1);
		int len2 = length(l2);
		// Pad the shorter list with zeros
		if(len1 > len2) {
			l2 = padListWithZeros(l2, len1-len2);
		} else {
			l1 = padListWithZeros(l1, len2-len1);
		}
		// Add
		SumInfo si = addListsHelper(l1, l2);
		
		// Deal with extra carry
		LinkedListNode result = si.sum;
		if(si.carry != 0) {
			result = addBefore(si.sum, si.carry);
		}
		return result;
	}
	
	// l1 and l2 must have the same length
	SumInfo addListsHelper(LinkedListNode l1, LinkedListNode l2) {
		if(l1 == null && l2 == null) {
			return new SumInfo();
		}
		SumInfo sum = addListsHelper(l1.next, l2.next);
		int s = l1.data + l2.data + sum.carry;
		sum.carry = s /10;
		sum.sum = addBefore(sum.sum, s%10);
		
		return sum;
		
	}
	LinkedListNode addBefore(LinkedListNode node, int data) {
		LinkedListNode newNode = new LinkedListNode(data);
		newNode.next = node;
		return newNode;
	}
	LinkedListNode padListWithZeros(LinkedListNode node, int kPadding) {
		while(kPadding>0) {
			
			node = addBefore(node, 0);
			kPadding--;
		}
		return node;
	}
	
	int length(LinkedListNode node) {
		int len = 0;
		while(node != null) {
			len++;
			node = node.next;
		}
		
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "123", num2 = "3456";
		LinkedListNode l1 = null, tail1 = null;
		LinkedListNode l2 = null, tail2 = null;
		
		AddNumber an = new AddNumber();
		
		char[] num1char = num1.toCharArray();
		char[] num2char = num2.toCharArray();
		
		for(char c : num1char) {
			if(l1 == null) {
				l1 = new LinkedListNode(c-'0');
				tail1 = l1;
			} else {
				tail1.next = new LinkedListNode(c-'0');
				tail1 = tail1.next;
			}
			
		}
		for(char c : num2char) {
			if(l2 == null) {
				l2 = new LinkedListNode(c-'0');
				tail2 = l2;
			} else {
				tail2.next = new LinkedListNode(c-'0');
				tail2 = tail2.next;
			}
			
		}
		
		LinkedListNode.printMe(an.addLists(l1, l2, 0));
		LinkedListNode.printMe(an.addListsForward(l1, l2));
	}

}
