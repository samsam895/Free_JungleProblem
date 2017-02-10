import jungle.Food;

public class Snake extends Animal {

	public int speak() {
		System.out.println("sssss");
		return speaks();
	}
	
	public int eat(Food food) {
		System.out.println("yomi yomi " + food.name());
		energy += 5;
		return energy;
	}
}
