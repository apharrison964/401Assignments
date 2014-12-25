package lec8.ex1.v3;

public class StudentImpl extends PersonImpl implements Student {

	private int credits;
	
	public StudentImpl(String first, String last, String address) {
		super(first, last, address); // calling super, so taking the info from super
		credits = 0;
	}
	
	public StudentImpl(String first, String last) {
		this(first, last, "Address Unknown"); // chain, so taking info from super
	}

	public void addCredits(int num_credits) {
		credits += num_credits;
	}

	public Status getStatus() {
		if (credits < 30) {
			return Status.FRESHMAN;
		} else if (credits < 60) {
			return Status.SOPHOMORE;
		} else if (credits < 90) {
			return Status.JUNIOR;
		}
		return Status.SENIOR;
	}
}


/* Sub interface vs. subclass, all the interface does is add behavior to the contract, does not specify
 * how it is fulfilled 
 * Extending a class is like copying and pasting the code from another class
 * You implement any interfaces your parent implements because of the is a relationship
 * All classes inherit from a special class called object, every single class inherits
 * from it, if you leave out extends, java puts it for you implicitly
 * A variable with data type object can hold anything
 * Public: everyone has access, breaks encapsulation
 * Private: only the class has access, subclass can't refer to it unless methods like super are called
 * Protected: like private but allows subclasses to manipulate the fields
 */
