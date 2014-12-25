package lec12.exception;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter exception level at prompt (0 for no exception)");
		while (true) {
			System.out.print("> ");
			int ex_level = s.nextInt();

			try {
				String l1 = levelOne(ex_level);
				System.out.println("Level One says: " + l1);
			} catch (RuntimeException e) {
				System.out.println("Caught exception at top:");
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static String levelOne(int ex_level) {
		System.out.println("Top of level one");

		if (ex_level == 1) {
			throw new RuntimeException("Exception at level one");
		}

		try {
			String l2 = levelTwo(ex_level);
			System.out.println("Level 2 says: " + l2);
		}
		catch (RuntimeException e) {
			System.out.println("Caught exception at level one:");
			System.out.println(e.getMessage());
		}

		
		return "I am level one!";
	}
	
	public static String levelTwo(int ex_level) {
		System.out.println("Top of level two");

		if (ex_level == 2) {
			throw new RuntimeException("Exception at level two");
		}

		try {
			String l3 = levelThree(ex_level);
			System.out.println("Level 3 says: " + l3);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Caught exception at level two:");
			System.out.println(e.getMessage());
		}
		
		return "I am level two!";
	}
	 static String levelThree(int ex_level) {
		System.out.println("Top of level three");
		
		if (ex_level == 3) {
			throw new RuntimeException("Exception at level three");
		}
		
		return "I am level three!";
	}


}

//Any method that calls or handles a check exception must catch it, or you can specifiy, 
//which would tell the other method that it occured, you
//don't need to catch it, you must indicate that you you are going to throw it
