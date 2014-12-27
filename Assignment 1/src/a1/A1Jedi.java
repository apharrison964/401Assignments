package a1;

import java.util.HashMap;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	public static void process(Scanner s) {

		HashMap<String, Integer> quantity = new HashMap<String, Integer>();
		HashMap<String, Double> cost = new HashMap<String, Double>();

		String name = s.next();
		double price = 0;
		double highestPrice = 0;
		int highestCount = 0;
		String highestCountname = null;
		String highestPricename = null;
		String avgName = null;
		double avgCost = 0;

		while (!name.equals("end")) {

			int inputQuantity = s.nextInt();
			price = s.nextDouble() * inputQuantity;

			if (quantity.containsKey(name)) {

				inputQuantity += quantity.get(name);
			}
			quantity.put(name, inputQuantity);

			if (cost.containsKey(name)) {

				price += cost.get(name);
			}
			cost.put(name, price);
			name = s.next();
		}

		for (String var : cost.keySet()) {

			double p = cost.get(var);
			int quan = quantity.get(var);
			double avgH = p / quan;

			if (highestPrice < p) {
				highestPrice = p;
				highestPricename = var;
			}

			if (highestCount < quan) {
				highestCount = quan;
				highestCountname = var;

			}
			if (avgH > avgCost) {
				avgCost = avgH;
				avgName = var;
			}
		}
		System.out.println("The largest count item with " + highestCount
				+ " was: " + highestCountname);
		System.out.println("The largest total cost item at " + highestPrice
				+ " was: " + highestPricename);
		System.out.println("The largest average cost item at " + avgCost
				+ " was: " + avgName);
	}
}
