package lec04;

import java.util.Arrays;

public class Lec04Example2 {

	public static void main(String[] args) {
		java.util.Scanner s = new java.util.Scanner(System.in);

		while(true) {
			int num_elements = s.nextInt();
			String element_type = s.next();

			if (element_type.equals("integer")) { //if integer is entered you know it is the number of elements
				int[] a = new int[num_elements];
				for (int i=0; i<num_elements; i++) {
					a[i] = s.nextInt();
				}
				System.out.println(Arrays.toString(a));
			} else if (element_type.equals("real")) { // real is doubles
				double[] a = new double[num_elements];
				for (int i=0; i<num_elements; i++) {
					a[i] = s.nextDouble();
				}
				System.out.println(Arrays.toString(a));			
			} else if (element_type.equals("string")) {
				String[] a = new String[num_elements];
				for (int i=0; i<num_elements; i++) {
					a[i] = s.next();
				}
				System.out.println(Arrays.toString(a));			
			} else {
				System.out.println("Unknown type, try again");
			}
		}
	}
	// does not matter about the whitespace

}
