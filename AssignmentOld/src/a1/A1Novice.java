package a1;

import java.util.Scanner;

public class A1Novice {

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	process(s);
	
}
public static void process(Scanner s) {

	String strand = s.next();

	int num_a = 0;
	int num_c = 0;
	int num_g = 0;
	int num_t = 0;

	while(!strand.equals("end")) {
		//			System.out.println(strand);

		for(int i=0; i < strand.length(); i++) {
			char c = strand.charAt(i);

			if (c == 'A') { 
				num_a++; 
			} else if (c == 'G') { 
				num_g++; 
			} else if (c == 'C') { 
				num_c++; 
			} else if (c == 'T') { 
				num_t++; }
		}

		strand = s.next();
	}

	System.out.println("A count: " + num_a);
	System.out.println("C count: " + num_c);
	System.out.println("G count: " + num_g);
	System.out.println("T count: " + num_t);

}
}