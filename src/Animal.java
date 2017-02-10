import jungle.Food;

public class Animal {

	int energy = 0;
	
	public int speaks(){
		energy -=3;
		return energy;	
	}
	
	public int sleep(){
		System.out.println("zzzzz");
		energy+=10;
		return energy;
	}
	
	public int eat(Food food){
		System.out.println("time to eat" + food.name());
		energy += 5;
		return energy;
	}
}
