package lec12.ex2;

public class ClassA {
	
	public void doAStuff() {
		Log.getLog().addEntry(this.toString() + " did something");
	}
	
}
