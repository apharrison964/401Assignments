package a1;

import java.util.Scanner;

public class A1Novice {
	
static double total_cost = 0;
static double total_quantity = 0;

public static void main (String[] args)	 {
	   Scanner s = new Scanner(System.in);
	   
	   process(s);
	
		}

public static void process(Scanner s) {
	
	int x = s.nextInt();
	int biggest = 0;
	String sBig = null;
	double biggestPrice = 0;
	String pBig = null;
	int totalItems = 0;
	double avgCost = 0;
	
	
	
	for (int i=0; i < x; i++) {
		
		String name = s.next();	
		int quantity = s.nextInt();
		double price = s.nextDouble();
		totalItems = totalItems + quantity;
		total_cost  +=  price * quantity;
		total_quantity += quantity;
		avgCost = total_cost / total_quantity;
		
		
		
		
		if (quantity >= biggest) {
			biggest = quantity;
			sBig = name;
			
		}
		
		if (price * quantity >= biggestPrice) {
			biggestPrice = price * quantity;
			pBig = name;
			
		}
		
		
	}
		System.out.println("The largest quantity item was: " + sBig);
		System.out.println("The largest cost item was: " + pBig);
		System.out.println("Total Cost: " +  total_cost);
		System.out.println("Average Cost: " + avgCost);
	}

}
