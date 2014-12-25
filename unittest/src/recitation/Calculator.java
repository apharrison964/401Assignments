package recitation;

public class Calculator {

	public int multiply(int x, int y){
		if(x > 999){
			throw new RuntimeException("X should be less than 10000");
		}
		return x + y;
	}
	
}
