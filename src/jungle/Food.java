package jungle;

import java.util.Random;

public enum Food {
	MEAT, FISH, BUGS, GRAIN;

	public static Food getRandomFood() {
		Random random = new Random();
		return values()[random.nextInt(values().length)];
	}
}
