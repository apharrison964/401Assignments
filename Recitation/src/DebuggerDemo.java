
public class DebuggerDemo {
	
	// Computes factorial recursively, making method to compute factorial
	static int factorial(int n) {
		// n! = n*(n-1)!
		if(n==0) 
			return 1;
			
			
		else
			return n*factorial(n-1);
		
  }
	
	public static void main(String[] args) {
		//2! = 2
		System.out.println(factorial(2));
		// 4! = 24
		System.out.println(factorial(4));
	}
	static void indexError(){
		int[] test = new int[10];
		test[10] = 5;
	}
}
