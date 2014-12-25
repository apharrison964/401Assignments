package lec12.ex5;

public class Main {

	public static void main(String[] args) {
		
		Service s1 = Service.getService();
		
		s1.doService();
		
		Service.goOnline();
		
		Service s2 = Service.getService();
		
		s2.doService();
	}
}
