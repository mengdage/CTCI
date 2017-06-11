package ch03.stack;

import java.util.Random;
import java.util.Stack;

public class MinStack {
	Stack<sElement> s =  new Stack<sElement>();
	public void push(int i){
		if(s.empty()){
			s.push(new sElement(i, i));
		}
		else{
			int min = getMin() > i? i : getMin();
			s.push(new sElement(i, min));
		}
	}
	public int pop(){
		return  s.pop().getData();
	}
	public int getMin(){
		if(s.empty()){
			return Integer.MAX_VALUE;
		}
		else{
			return  s.peek().getMin();
		}
		
	}
	public boolean empty(){
		return s.empty();
	}
	
	public static void main(String[] args){
		Random r = new Random(12);
		MinStack mstack1 = new MinStack();
		for(int i = 0; i < 10; i++){
			mstack1.push(r.nextInt(50));
		}
		while(!mstack1.empty()){
			System.out.println("Min: " + mstack1.getMin() + "; value: " + mstack1.pop());
		}
		
		System.out.println("Min: " + mstack1.getMin() + "; value: " + mstack1.pop());
	}

}

class sElement{
	private int data;
	private int min;
	public sElement(int d, int m) {
		// TODO Auto-generated constructor stub
		data = d;
		min = m;
	}
	public int getData() {
		return data;
	}
	
	public int getMin() {
		return min;
	}
	
}