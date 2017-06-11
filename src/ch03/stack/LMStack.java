package ch03.stack;

import java.util.Stack;

public class LMStack {
	private int capacity;
	private int top;
	private String id = "";
	
	private int[] content;
	
	public String getId(){
		return id;
	}
	public int size(){
		return top;
	}
	public LMStack(){
		capacity = 50;
		content = new int[capacity];
		top = 0;
	}
	public LMStack(int size){
		capacity = size;
		content = new int[capacity];
		top = 0;
	}
	public LMStack(int size, String id){
		this.id = id;
		capacity = size;
		content = new int[capacity];
		top = 0;
	}
	
	public boolean push(int ipt){
		if(top == capacity ){
			return false;
		}
		else{
			content[top++] = ipt;
			return true;
		}
	}
	
	public int pop() {
		if(empty()) throw new MyStackEmptyException();
		return content[--top];
	}
	public int peek() throws MyStackEmptyException{
		if(empty()) throw new MyStackEmptyException();
		return content[top-1];
	}
	
	public boolean empty(){
		if(top == 0) {
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		if(id != ""){
			result.append("stakc#" + id + "[ ");
		}
		else{
			result.append("stakc"+ "[ ");
		}
		for(int i = 0; i < top; i++){
			result.append(content[i]);
			result.append(" ->");
		}
		result.append("]");
		return result.toString();
	}
	
	
	public static void main(String[] args) {
		LMStack lms = new LMStack();
		lms.push(1);
		lms.push(2);
		lms.push(3);
		
		System.out.println(lms.pop());
		System.out.println(lms.pop());
		System.out.println(lms.pop());
		System.out.println(lms.pop());
		
	}
	
	
	
}
