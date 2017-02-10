import jungle.Food;

public class Monkey extends Animal{
	
	
	public int speak() {
		System.out.println("eeek");
		return speaks();
	}

	public int eat(Food food) {
		System.out.println("yomi yomi " + food.name());
		energy += 2;
		return energy;
	}
	
	public int play() {
		if (energy >= 8) {
			System.out.println("Oooo Oooo Oooo");
			energy -= 8;
		} else {
			System.out.println("Monkey is too tired");
		}
		return energy;
	}
	

}
