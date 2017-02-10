import jungle.Food;

public class Tiger extends Animal {

	public int speak() {
		System.out.println("Rawwr");
		return speaks();
	}

	public int sleep() {
		System.out.println("sleeping zzzz");
		energy += 5;
		return energy;
	}
	
	public int eat(Food food) {
		if (food.name().equalsIgnoreCase("GRAIN")) {
			System.out.println("Grains is discusting I need animal protein");
		} else {
			System.out.println("yomi yomi " + food.name());
			energy += 5;
		}
		return energy;
	}
}
