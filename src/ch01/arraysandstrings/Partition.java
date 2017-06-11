package ch01.arraysandstrings;

import java.util.Random;

public class Partition {

	 public LinkedListNode partition(LinkedListNode node, int x) {
		 LinkedListNode beforeStart = null;
		 LinkedListNode beforeEnd = null;
		 LinkedListNode afterStart = null;
		 LinkedListNode afterEnd = null;
		 
		 while(node != null) {
			 LinkedListNode next = node.next;
			 node.next = null;
			 
			 if(node.data < x) {
				 // Insert node into end of before list
				 if(beforeStart == null) {
					 beforeStart = node;
					 beforeEnd = beforeStart;
				 } else {
					 beforeEnd.next = node;
					 beforeEnd = beforeEnd.next;
				 }
			 } else {
				 // Insert node into end of after list
				 if(afterStart == null) {
					 afterStart = node;
					 afterEnd = afterStart;
				 } else {
					 afterEnd.next = node;
					 afterEnd = afterEnd.next;
				 }
			 }
			 node = next;
		 }
		 
		 // no data < x
		 if(beforeStart == null) {
			 return afterStart;
		 }
		 
		 beforeEnd.next = afterStart;
		 return beforeStart;
	 }
	 public LinkedListNode partition2(LinkedListNode node, int x) {
		 LinkedListNode head = node;
		 LinkedListNode tail = node;
		 
		 while(node != null) {
			 LinkedListNode next = node.next;
			 if(node.data < x) {
				 node.next = head;
				 head = node;
			 } else {
				 tail.next = node;
				 tail = node;
			 }
			 node = next;
		 }
		 tail.next = null;
		 
		 return head;
	 }
	 public static void main(String[] args) {
		 LinkedListNode node = new LinkedListNode(1);
		 
		 LinkedListNode tail = node;
		 Random rd = new Random(123);
		 for(int i = 0; i < 9; i++) {
			 tail.next = new LinkedListNode(rd.nextInt(10));
			 tail = tail.next;
		 }
		 LinkedListNode.printMe(node);
		 
		 Partition p = new Partition();
		 LinkedListNode sortedNode = p.partition(node, 5);
		 LinkedListNode.printMe(sortedNode);
		 LinkedListNode sortedNode2 = p.partition2(node, 5);
		 LinkedListNode.printMe(sortedNode2);
	 }
}
