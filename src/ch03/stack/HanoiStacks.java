package ch03.stack;

public class HanoiStacks {

	private LMStack oneTower = new LMStack(50, "thower#1");
	private LMStack twoTower = new LMStack(50, "thower#2");
	private LMStack threeTower = new LMStack(50,"thower#3");
	private int steps = 0;
	
	public HanoiStacks(){
		for(int i = 5; i >0 ; i--){
			oneTower.push(i);
		}
	}

	public HanoiStacks(int num){
		if(num<0){
			num = -num;
		}
		for(int i = num; i >0 ; i--){
			oneTower.push(i);
		}
	}
	
	public void startHanoi(){
		if(oneTower.empty()) return;
		move(oneTower.size(), oneTower, threeTower, twoTower);
		
	}
	public void move(int num, LMStack from, LMStack to, LMStack buf){
		if(num == 1) {
			System.out.println("move " + from.peek() + " from " + from.getId() + " to " + to.getId());
			++steps;
			to.push(from.pop());
		}else{

			move(num-1, from, buf, to);
			move(1, from, to, buf);
			move(num-1, buf, to, from);
		}
		
	}
	public String toString(){
		return "steps: " + steps + "\n" + oneTower.toString() +"\n"+ twoTower.toString() + "\n" + threeTower.toString();
	}
	
	public static void main(String[] args){
		HanoiStacks hs = new HanoiStacks(15);
		System.out.println(hs);
		hs.startHanoi();
		
		System.out.println(hs);
	}
	
	
}
