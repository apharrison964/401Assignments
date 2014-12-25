package lec09.ex3;

public class Main {

	public static void main(String[] args) {
		A a_obj = new A();
		SubA suba_obj = new SubA();
	
		System.out.println("a_obj.method(1,2): " + 
							a_obj.method(1, 2));
		
		System.out.println("suba_obj.method(1,2): " + 
							suba_obj.method(1, 2));
	}
}

class A {
	public int method(int x, int y) {
		return x+y;
	}
}

class SubA extends A {
	@Override
	public int method(int x, int y) {
		return x-y;
	}
}
/*
* Override does not need to be there, but it can be useful, saying that you intend
* for the method to be overrided, or it can implement that you want to implement another implementation
* If the name of the method does not match, the compiler complains, has to have the same thing as the parent
* Good way to find mistakes, compiler will check to see if it does override a method
* Polymorphisim:
* Covariance is treating an instance of a sublcass as a reference typed as the parent class, can be typed checked
* at compile time
* Contravarience is treating a reference typed as the arent class as an instance of a sublclass, cannot be type
* checked at compile, fails if object is invariant
*/