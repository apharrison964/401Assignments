package lec10.ex1;

public class Student {

	private String first;
	private String last;
	
	Student (String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public String getFullName() {
		return first + " " + last;
	}
	
}
