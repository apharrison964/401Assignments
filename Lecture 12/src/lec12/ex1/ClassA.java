package lec12.ex1;

public class ClassA {
	
	public void doAStuff() {
		Log.getLog().addEntry(this.toString() + " did something");
	}
	
}
