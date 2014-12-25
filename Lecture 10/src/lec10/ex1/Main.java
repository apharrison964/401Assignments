package lec10.ex1;

public class Main {

	public static void main(String[] args) {
		
		Professor kmp = new Professor("Ketan", "Mayer-Patel");
		Professor dewan = new Professor("Prasun", "Dewan");
		
		Room gc1015 = new Room("Global Center", 1015);
		Room sn011 = new Room("Sitterson", 11);
		
		Student s1 = new Student("Alan", "Turing");
		Student s2 = new Student("Charles", "Babbage");
		Student s3 = new Student("Haskell", "Curry");
		Student s4 = new Student("Ada", "Lovelace");
		Student s5 = new Student("Jim", "Gray");
		
		Course c1 = new Course(University.Term.SPRING, 2014,
				               University.Department.COMP, 401,
				               gc1015, kmp);
		
		Course c2 = new Course(University.Term.FALL, 2014,
							   University.Department.COMP, 416,
							   sn011, kmp);
		
		Course c3 = new Course(University.Term.FALL, 2014,
							   University.Department.COMP, 426,
							   gc1015, kmp);
		
		c1.addStudent(s1);
		c1.addStudent(s2);
		c1.addStudent(s3);
		
		c1.printRoster();
		
	    c2.addStudent(s1);
	    c2.addStudent(s2);
	    
	    c2.printRoster();
	    
	    c3.addStudent(s1);
	    c3.addStudent(s2);
	    c3.addStudent(s3);
	    c3.addStudent(s4);
	    c3.addStudent(s5);
	    
	    c3.printRoster();
	    
	    c2.setProf(dewan);
	    
	    c2.printRoster();
	    
	    c3.setRoom(sn011);
	    
	    c3.printRoster();
	    
	}
}
