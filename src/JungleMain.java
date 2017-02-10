import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import jungle.Food;


public class JungleMain {

	private List<Animal> animals = new ArrayList<Animal>();
	
	
	public static void main(String[] args) {
		System.out.println("\nWelcome to the Jungle");
		JungleMain jungle = new JungleMain();
		jungle.init();
		jungle.soundOff();
		System.out.println();
		jungle.doRandomAction();
		jungle.getCount("Tiger");
		jungle.getCount("Snake");
		jungle.getCount("Monkey");
	}
	
	@SuppressWarnings("rawtypes")
	public void init() {
		List<Class> animalTypes = new ArrayList<Class>();
		animalTypes.add(Tiger.class);
		animalTypes.add(Monkey.class);
		animalTypes.add(Snake.class);
		

		Random rand = new Random();
		int randomAnimal = rand.nextInt(animalTypes.size());

		for (int i = 0; i < 10; i++) {
			randomAnimal = rand.nextInt(animalTypes.size());
			Class atype = animalTypes.get(randomAnimal);
			Constructor[] constructors = atype.getDeclaredConstructors();
			try {
				Animal a = (Animal) constructors[0].newInstance();
				animals.add(a);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void soundOff() {
		System.out.println("Animals Sound Off!");
		for (Animal animal : animals) {
			animal.speaks();
		}
	}

	public void doRandomAction() {
		System.out.println("Do Random Actions");
		for (Animal animal : animals) {
			// System.out.println(animal.getClass().getName());
			Method[] pmethods = Animal.class.getDeclaredMethods();
			Method[] cmethods = animal.getClass().getDeclaredMethods();

			Map<String, Method> methods = new HashMap<String, Method>();
//			System.out.println("on hash");
//			 System.out.println("Child Methods");
			for (Method method : cmethods) {
//				 System.out.println("method = " + method.getName());
				methods.put(method.getName(), method);
			}
//			System.out.println("samsam"+methods);
//			 System.out.println("Parent Methods");
			for (Method method : pmethods) {
				if (!methods.containsKey(method.getName())) {
//					 System.out.println("method = " + method.getName());
					methods.put(method.getName(), method);
				}
			}
			List<Method> allMethods = new ArrayList<Method>();
			allMethods.addAll(methods.values());

			Random randM = new Random();
			int randomMethod = randM.nextInt(allMethods.size());

			Method method = allMethods.get(randomMethod);
			try {
				System.out.println(animal.getClass().getSimpleName()
						+ " is trying to " + method.getName());
				if (method.getParameterCount() == 0) {
					method.invoke(animal);
				} else {
					method.invoke(animal, Food.getRandomFood());
				}
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*
	 * animals can know how many of their species exist in the jungle but only
	 * the jungle has the list so the method is here.
	 */
	public int getCount(String animalType) {
		int count = 0;
		for (Animal animal : animals) {
			if (animal.getClass().getSimpleName().equalsIgnoreCase(animalType)) {
				count++;
			}
		}
		System.out.println("There are " + count + " " + animalType
				+ "s in the Jungle");
		return count;
	}
}
