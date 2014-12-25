package lec10.ex1;

import java.util.List;
import java.util.ArrayList;

public class Course {

	private University.Term term;
	private int year;
	private University.Department dept;
	private int course_number;
	private Room room;
	private Professor prof;
	private List<Student> students;
	
	Course (University.Term term,
			int year,
			University.Department dept,
			int course_number,
			Room room,
			Professor prof) {

		this.term = term;
		this.year = year;
		this.dept = dept;
		this.course_number = course_number;
		this.room = room;
		this.prof = prof;
		students = new ArrayList<Student>();
	}
	
	public void addStudent(Student s) {
		if (!students.contains(s)) {
			students.add(s); //course as a whole object that has component parts are not just to be part of course,
								//they exist outside of course also
		}
	}
	
	public void dropStudent(Student s) {
		students.remove(s);
	}
	
	public Professor getProf() {
		return prof;
	}
	
	public void setProf(Professor p) {
		prof = p;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room r) {
		room = r;
	}
	
	public void printRoster() {
		System.out.println(dept + " " + course_number + 
				           "(" + term + " " + year + ")" );
		System.out.println("Taught by " + prof.getFullName());
		System.out.println("----------------------");
		for (Student s : students) {
			System.out.println(s.getFullName());
		}
	}	
}

//Characteristics of Aggregations
// Encapsulated objects provided externally, parameters, getters and setters are often provided
