package ch03.stack;
import java.util.Random;
import java.util.Stack;
public class MinStack2 {
	Stack<Integer> dataStack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int i){
		if(dataStack.empty()){
			dataStack.push(i);
			minStack.push(i);
		}
		else{
			dataStack.push(i);
			if(minStack.peek() >= i){
				minStack.push(i);
			}
		}
	}
	
	public int pop(){
		int res = dataStack.pop();
		if(res == getMin()){
			minStack.pop();
		}
		return res;
	}
	
	public int getMin(){
		if(minStack.empty()){
			return Integer.MAX_VALUE;
		}
		else{
			return minStack.peek();
		}
	}
	public boolean empty(){
		return dataStack.empty();
	}
	
	public static void main(String[] args){
		Random r = new Random(12);
		MinStack2 mstack1 = new MinStack2();
		for(int i = 0; i < 10; i++){
			mstack1.push(r.nextInt(50));
		}
		while(!mstack1.empty()){
			System.out.println("Min: " + mstack1.getMin() + "; value: " + mstack1.pop());
		}
		
		System.out.println("Min: " + mstack1.getMin() );
	}
	
}
