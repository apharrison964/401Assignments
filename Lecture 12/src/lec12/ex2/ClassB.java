package lec12.ex2;

public class ClassB {

	public void doBStuff() {
		Log.getLog().addEntry(this.toString() + " logged this");
	}
}
