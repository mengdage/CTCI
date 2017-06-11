package ch03.queue;

public abstract class Animal {
	private int order;
	protected String name;
	public Animal(String n){
		name = n;
	}
	
	public void setOrder(int ord){
		order = ord;
	}
	
	public int getOrder(){
		return order;
	}
	
	public boolean isOrderThan(Animal a){
		return this.order < a.getOrder();
	}
	public abstract String toString();
}
