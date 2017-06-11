package ch03.queue;

import java.util.LinkedList;
import java.util.Random;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order++);
		
		if( a instanceof Dog){
			dogs.push((Dog)a);
		}
		else{
			cats.push((Cat) a); 
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.size() == 0){
			return dequeueCat();
		}
		else if(cats.size() == 0){
			return dequeueDog();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if(dog.isOrderThan(cat)){
			return dequeueCat();
		}
		else{
			return dequeueDog();
		}
	}
	
	public Dog dequeueDog(){
		return dogs.poll();
	}
	
	public Cat dequeueCat(){
		return cats.poll();
	}
	
	
public static void main(String[] args) {
	AnimalQueue animals = new AnimalQueue();
	Random rand = new Random(123);
	
	for(int i =10; i >0; --i){
		if(rand.nextInt() % 2 == 0){
			animals.enqueue(new Dog("dog#" + (11-i)));
			System.out.println("dog#" + (11-i));
		}
		else{
			animals.enqueue(new Cat("cat#" + (11-i)));
			System.out.println("cat#" + (11-i));
		}
	}
	
	System.out.println(animals.dequeueCat());
	System.out.println(animals.dequeueAny());
	System.out.println(animals.dequeueAny());
	System.out.println(animals.dequeueDog());
}	
	

}
