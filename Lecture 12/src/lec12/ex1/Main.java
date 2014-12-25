package lec12.ex1;

public class Main {

	public static void main(String[] args) {
		ClassA a1 = new ClassA();
		ClassA a2 = new ClassA();
		ClassB b1 = new ClassB();
		ClassB b2 = new ClassB();
		
		a1.doAStuff();
		b2.doBStuff();
		a2.doAStuff();
		a1.doAStuff();
		b1.doBStuff();
		
		Log.getLog().printLog();
	}
}
