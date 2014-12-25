package lec09.ex6;

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
	public int m() {return ((A) this).m() + 1;}
}

class C extends B { 
	public int m() {return ((B) this).m() + 2;}
}
// Does not work because you get the real value of whatever, it will call itself and then get into
// an infinite loop
/*
 * The super keyword turns virtual methods off, super is a reference to the current reference of the covarient
 * and this is just a reference to the current reference
  */
