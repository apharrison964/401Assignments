package lec12.ex3;
//MULTITON
import java.util.Map;
import java.util.HashMap;

public class Student {

	private String last_name;
	private String first_name;
	private int PID; // identifying constructor
	
	private Student(String last_name, String first_name, int PID) {
		this.last_name = last_name;
		this.first_name = first_name;
		this.PID = PID;
	}
	
	public String getLastName() {
		return last_name;
	}

	public String getFirstName() {
		return first_name;
	}
	
	public int getPID() {
		return PID;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + last_name + ", " + first_name + ")";
	}
	
	// Below are things we need to create a multiton
	
	// all_students is the static structure where we will store existing
	// Student objects. 
	
	private static Map<Integer,Student> all_students = new HashMap<Integer, Student>();

	// getStudent() is factory method
	public static Student getStudent(String last_name, String first_name, int PID) {		
		if (all_students.containsKey(PID)) {
			return all_students.get(PID);
		} else {
			Student new_student = new Student(last_name, first_name, PID);
			all_students.put(PID, new_student);
			return new_student;
		}
	}
		
	// lookupStudent() is factory method variant that does not create
	// new Student object if not already existing. Returns null if
	// student does not exist.
	
	public static Student lookupStudent(int PID) {
		// Map returns null if key not defined so matches what we want to do.
		return all_students.get(PID);
	}
}
//You use a multiton when you want to create an object that represents an object, but if there is another object
//you want to make that is the same thing, you want to make sure you retrieve the exact same thing, multiton is static
//The mutiton pattern has to have a structure that saves the structure and it needs to have a way to index it
//Used mostly with Map, and interface, anything can be a map if it operates in a specific way
//HashMap is a map of the interface Map, they both are generics(specified by more types)
//Map takes two types, the first the type of the key and the second by the type of value, map
//lets you find items by a key, both have to be reference types
