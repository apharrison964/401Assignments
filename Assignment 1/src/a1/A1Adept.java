package a1;


import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		process(s);
	}

	static void process(Scanner s) {

		int[] items = new int[10];
		double[] cost = new double[10];
		int category = 0;
		int quantity = 0;
		double price = 0;
		int biggestQuantity = 0;
		int smallestQuantity = Integer.MAX_VALUE;
		double biggestPrice = 0;
		double smallestPrice = Double.MAX_VALUE;
		int categoryBiggestitem = 0;
		int categorySmallestitem = 0;
		int categorySmallestprice = 0;
		int categoryBiggestprice = 0;
	

		while (true) {

			
			
			String name = s.next();
			if (name.equals("end")) {
				break;
			}
			category = s.nextInt();
			quantity = s.nextInt();
			price = s.nextDouble();
			cost[category] += price * quantity;
			items[category] += quantity;
		}
		for (int i = 0; i < items.length; i++) {

			if (items[i] > biggestQuantity) {
				biggestQuantity = items[i];
				categoryBiggestitem = i;

			}

			if (items[i] < smallestQuantity && items[i] != 0) {
				smallestQuantity = items[i];
				categorySmallestitem = i;

			}

			if (cost[i] > biggestPrice) {
				biggestPrice = cost[i];
				categoryBiggestprice = i;

			}

			if (cost[i] < smallestPrice && items[i] != 0) {
				smallestPrice = cost[i];
				categorySmallestprice = i;
			}

		}

		System.out.println("Category with the most items: " + categoryBiggestitem);
		System.out.println("Category with the fewest items: "+ categorySmallestitem);
		System.out.println("Category with the largest cost: " + categoryBiggestprice);
		System.out.println("Category with the least cost: " + categorySmallestprice);

	}
}
