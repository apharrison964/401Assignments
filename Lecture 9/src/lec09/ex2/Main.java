package lec09.ex2;

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
	public int method(int x, int y) {
		return x-y;
	}
}
/*Subclass can override the thing it inherited, offering a different implementation
* But they can say they want to do something different from the parent, even though they
* inherited it from the parent. You have to define the method as the same method you are changing from
* the parent
*/