package a5tester;

import java.util.NoSuchElementException;
import java.util.Iterator;
import a5jedi.*;
import comp401.sushi.*;

public class JediTester implements Tester {
	
	public ErrorLog run(String level) throws PlatePriceException, BeltPlateException, BeltFullException {
		ErrorLog result = new ErrorLog();
		result.add(String.format("checking at level'%s'", level));
		switch (level){
		case "novice":
			result.addAll(this.novice());
			break;
		case "adept":
			result.addAll(this.adept());
			break;
		case "jedi":
			result.addAll(this.jedi());
			break;
		default:
			throw new IllegalArgumentException();
		}
		return result;
	}
	
	private ErrorLog novice() throws PlatePriceException, BeltPlateException {
		
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
		
		// <- BeltClass
		
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
	
	private ErrorLog adept() throws PlatePriceException, BeltPlateException, BeltFullException {
		
		ErrorLog results = new ErrorLog();
		
		Belt test_belt = new Belt(5);
		Plate test_plate = new BluePlate(new Sashimi(Sashimi.SashimiType.CRAB));
		Plate test_plate2 = new BluePlate(new Sashimi(Sashimi.SashimiType.TUNA));
		
		test_belt.setPlateAtPosition(test_plate, 0);
		test_belt.setPlateAtPosition(test_plate, 2);
		test_belt.setPlateAtPosition(test_plate, 3);
		test_belt.setPlateAtPosition(test_plate, 4);
		
		//check Belt class ->
		
		results.add("checking Belt...");

		results.add("checking new methods...");
		//check setPlateNearestToPosition
		results.addFromAssert(Asserts.equals(
				test_belt.setPlateNearestToPosition(test_plate2, 2),
				1,
				"setPlateNearestToPosition (return)"));
		
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(1),
				test_plate2,
				"setPlateNearestToPosition (action)"));
		
		//check rotate
		test_belt.rotate();
		test_belt.rotate();
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(3),
				test_plate2,
				"rotate (via getPlateAtPosition)"));
		
		//check execptions are thrown
		results.add("checking exceptions...");
		boolean thrown;
		try {
			test_belt.setPlateNearestToPosition(test_plate, 1);
			thrown=false;
		}
		catch (BeltFullException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				true,
				"BeltFullException (setPlateNearestToPosition)"));
		try {
			test_belt.getPlateAtPosition(6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				false,
				"IllegalArgumentException (getPlateAtPosition)"));
		test_belt.clearPlateAtPosition(1);
		try {
			test_belt.setPlateAtPosition(test_plate, 6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				false,
				"IllegalArgumentException (setPlateAtPosition - index)"));
		try {
			test_belt.clearPlateAtPosition(6);
			thrown=false;
		}
		catch (IllegalArgumentException e){
			thrown=true;
		}
		results.addFromAssert(Asserts.equals(
				thrown,
				false,
				"IllegalArgumentException (clearPlateAtPosition)"));
		
		// <- Belt
		
		// check BeltFullException class ->
		
		results.add("checking BeltFullException...");

		results.add("checking getter...");
		
		BeltFullException test_exception = new BeltFullException(test_belt);
		results.addFromAssert(Asserts.equals(
				test_exception.getBelt(),
				test_belt,
				"getBelt"));
		return results;
		
}

	private ErrorLog jedi() throws PlatePriceException, BeltPlateException, BeltFullException {
		
		ErrorLog results = new ErrorLog();
		
		Belt test_belt = new Belt(5);
		Plate test_plate = new BluePlate(new Sashimi(Sashimi.SashimiType.CRAB));		
		test_belt.setPlateAtPosition(test_plate, 0);
		test_belt.setPlateAtPosition(test_plate, 1);
		test_belt.setPlateAtPosition(test_plate, 2);
		test_belt.setPlateAtPosition(test_plate, 4);
		Plate test_plate2 = new GoldPlate(new Sashimi(Sashimi.SashimiType.CRAB), 8);		
		test_belt.setPlateAtPosition(test_plate2, 3);
		
		//check Belt class ->
		
		results.add("checking Belt...");
		
		//check overloaded iteratorFromPosition

		results.add("checking new overloaded methods...");
		
		Iterator<Plate> color_iterator=test_belt.iteratorFromPosition(0, Plate.Color.GOLD);
		results.addFromAssert(Asserts.equals(
				color_iterator.next(),
				test_plate2,
				"iteratorFromPosition(int, Plate.Color)"));
		
		Iterator<Plate> price_iterator=test_belt.iteratorFromPosition(3, 5);
		results.addFromAssert(Asserts.equals(
				price_iterator.next(),
				test_plate,
				"iteratorFromPosition(int, double)"));
		
		// <- Belt
		
		//check BeltIterator class ->
		
		results.add("checking BeltIterator...");

		results.add("checking new method...");
		
		Iterator<Plate> test_iterator=test_belt.iterator();
		//check remove
		test_iterator.next();
		test_iterator.remove();
		results.addFromAssert(Asserts.equals(
				test_belt.getPlateAtPosition(0),
				null,
				"remove"));
		
		// <- BeltIterator
		
		return results;
		
	}
}
