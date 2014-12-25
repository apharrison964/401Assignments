package lec10.ex1;

public class Professor {

	private String first;
	private String last;
	
	Professor(String first, String last) {
		this.first = first;
		this.last = last;
	}
	
	public String getFullName() {
		return first + " " + last;
	}
}
