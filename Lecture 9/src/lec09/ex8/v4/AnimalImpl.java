package lec09.ex8.v4;

public class AnimalImpl { //Parent class

	private Point3D location;
	private int id;

	AnimalImpl(int id, Point3D location) {
		this.id = id;
		this.location = location;
	}
	
	public int getID() {
		return id;
	}
	
	public Point3D getLocation() {
		return location;
	}
	
	public void move(Point3D destination) {
		location = destination;
	}
}
// speak() is common behavior, so we want it to be part of Animal, but we have no speak implementation
// no good default of commonalities in way of speaking
// abstract classes and methods, want to define the parent class that has
//most of the info, and you want to subclasses to fill in the rest, sometimes the parent is there
//just to provide the framework, is there to support the subclass
//Can use the abstract modifier, can use in front of any method declaration we know will be used
//in all subclasses but we know the subclass will provide the inso