package ch01.arraysandstrings;

public class LinkedListNode {
	public int data;
	public LinkedListNode next;
	
	public LinkedListNode() {
		data = 0;
		next = null;
	}
	public LinkedListNode(int d) {
		data = d;
		next = null;
	}
	
	public static void printMe(LinkedListNode node) {
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
