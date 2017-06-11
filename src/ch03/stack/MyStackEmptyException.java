package ch03.stack;

public class MyStackEmptyException extends RuntimeException{
	public MyStackEmptyException(){
	}
	public MyStackEmptyException(String s){
		super(s);
	}

}
