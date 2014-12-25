package lec09.ex7;

public class Main {


	public static void main(String[] args) {
		C c_obj = new C();
		B b_obj = new B();
		A a_obj = new A();

		System.out.println(c_obj.m());
		System.out.println(b_obj.m());
		System.out.println(a_obj.m());
	}

}

class A {
	public int m() {return 0;}
}

class B extends A {
	public int m() {return super.m() + 1;}
}

class C extends B { 
	public int m() {return super.m() + 2;}
}
// Can get to the parent using a superclass, can't be outside of the subclass or you can't get
//what you need
// Use inheritance when related classes have common internals, not just common behavior
// Details of hte internals must be the same, NOT JUST COMMON BEHAVIOR, thats when you use interfaces
//Also when you created a lot of classes and you need the same object later, and you would
//use inheritance, so you would subclass to add the rest of the stuff you want ie override or
//overload
// Subinterfacing is between two interfaces, can call on each other
//Classing is inheriting actual implementation from the parent class, can control visibility
//Overloading parent methods, create a new version
//Overriding parent methods, same signiture as in parent, always virtual