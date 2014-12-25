package a5tester;

import java.util.NoSuchElementException;
import a5novice.*;
import comp401.sushi.*;

public class NoviceTester implements Tester {
	
	public ErrorLog run(String level) throws PlatePriceException, BeltPlateException {
		ErrorLog results = new ErrorLog();
		
		Belt test_belt = new Belt(5);
		Plate test_plate = new BluePlate(new Sashimi(Sashimi.SashimiType.CRAB));
		
		// check Belt class ->
		
		results.add("checking Belt...");
		
		//check constructor
		results.add("checking constructor...");
		results.addFromAssert(Asserts.type(
				test_belt,
				Belt.class,
				"Belt"));
		
		//check getters and setters
		results.add("checking getters and setters...");
		test_belt.setPlateAtPosition(test_plate, 3);
		results.addFromAssert(Asserts.equals(
				test_belt.getSize(),
				5,
				"getSize"));
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(3),
				test_plate,
				"setPlateAtPosition (via getPlateAtPosition)"));
		test_belt.clearPlateAtPosition(3);
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(3),
				null,
				"clearPlateAtPosition (via getPlateAtPosition)"));
		test_belt.setPlateAtPosition(test_plate, 3);
		results.addFromAssert(Asserts.equals(
				test_belt.removePlateAtPosition(3),
				test_plate,
				"removePlateAtPosition (return)"));
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(3),
				null,
				"removePlateAtPosition (action)"));
		
		//check exceptions are thrown
		results.add("checking exceptions...");
		boolean thrown;
		try {
			test_belt.getPlateAtPosition(6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"IllegalArgumentException (getPlateAtPosition)"));
		
		try {
			test_belt.setPlateAtPosition(null, 4);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"IllegalArgumentException (setPlateAtPosition - null)"));
		
		try {
			test_belt.setPlateAtPosition(test_plate, 6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"IllegalArgumentException (setPlateAtPosition - index)"));
		
		test_belt.setPlateAtPosition(test_plate, 3);
		try {
			test_belt.setPlateAtPosition(test_plate, 3);
			thrown=false;
		}
		catch (BeltPlateException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"BeltPlateException (setPlateAtPosition)"));
		
		try {
			test_belt.clearPlateAtPosition(6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"IllegalArgumentException (clearPlateAtPosition)"));
		
		try {
			test_belt.removePlateAtPosition(1);
			thrown=false;
		}
		catch (NoSuchElementException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"NoSuchElementException (removePlateAtPosition)"));
		
		// <- Belt
		
		// check BeltPlateException class ->
		
		results.add("checking BeltPlateException...");
		
		results.add("checking getters...");
		BeltPlateException test_exception = new BeltPlateException(3, test_plate, test_belt);
		results.addFromAssert(Asserts.equals(
				test_exception.getPosition(),
				3,
				"getPosition"));
		results.addFromAssert(Asserts.equals(
				test_exception.getPlateToSet(),
				test_plate,
				"getPlateToSet"));
		results.addFromAssert(Asserts.equals(
				test_exception.getBelt(),
				test_belt,
				"getBelt"));
		
		// <- BeltPlateException
		
		return results;
	}
	
}