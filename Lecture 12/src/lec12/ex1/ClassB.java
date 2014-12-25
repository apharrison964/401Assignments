package lec12.ex1;

public class ClassB {

	public void doBStuff() {
		Log.getLog().addEntry(this.toString() + " logged this");
	}
}
