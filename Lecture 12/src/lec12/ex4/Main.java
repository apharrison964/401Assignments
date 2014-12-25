package lec12.ex4;

public class Main {

	public static void main(String[] args) {
		
		Student s1 = Student.getStudent("McAdoo", "James Michael", 123);
		Student s2 = Student.getStudent("Bullock", "Reggie", 456);
		
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		
		Student s3 = Student.getStudent("McAdoo", "James Michael", 123);
		
		System.out.println("s3 = " + s3);

		Student s4 = Student.getStudent("Doe", "John", 456);
		
		System.out.println("s4 = " + s4);

		try {
			Student s5 = Student.lookupStudent(123);
			System.out.println("s5 = " + s5); 

			Student s6 = Student.lookupStudent(789);			
			System.out.println("s6 = " + s6);

		} catch (NoSuchStudentException e) {
			System.out.println(e);
		}
		
	}
}
