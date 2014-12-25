package a6testers;

import comp401.sushi.*;
import java.util.NoSuchElementException;
import a6adept.Belt;
import a6adept.BeltFullException;
import a6adept.BeltPlateException;
import a6adept.PlateCounter;
import a6adept.ProfitCounter;

public class adeptTesterMain {

	public static void main(String[] args) throws comp401.sushi.PlatePriceException, 
											IllegalArgumentException,
											BeltPlateException,
											NoSuchElementException, 
											BeltFullException {
		
		//create some sushi and put onto plates to be tested
		Sushi nigiriSushi = new Nigiri(Nigiri.NigiriType.SALMON);
		RedPlate red = new RedPlate(nigiriSushi);
			
		Sushi sashimiSushi = new Sashimi(Sashimi.SashimiType.TUNA);
		GreenPlate green = new GreenPlate(nigiriSushi);
				
		Ingredient[] ingredients = {new comp401.sushi.Avocado(2), new Crab(2)};
		Sushi rollSushi = new Roll(ingredients);
		GoldPlate gold = new GoldPlate(rollSushi, 5.0) ;
		
		Belt belt = new Belt(3);
		
		//Create new observer objects and add them to belt
		PlateCounter counter = new PlateCounter();
		ProfitCounter profit = new ProfitCounter();
		
		belt.addObserver(counter);
		belt.addObserver(profit);
				
		//Test the update method for PlateCounter
		System.out.println("Testing the PlateCounter observer...\n");
	
		belt.setPlateAtPosition(red, 0);
		belt.setPlateAtPosition(green, 1);
		belt.setPlateAtPosition(gold, 2);
		
		int redCount = counter.getGoldPlateCount();
		int greenCount = counter.getGreenPlateCount();
		int goldCount = counter.getGoldPlateCount();
		
		System.out.println("We should have one red plate on our belt: " + redCount);
		System.out.println("We should have one green plate on our belt: " + greenCount);
		System.out.println("We should have one gold plate on our belt: " + goldCount);
		
		belt.clearPlateAtPosition(0);
		belt.clearPlateAtPosition(1);
		belt.clearPlateAtPosition(2);
		
		redCount = counter.getRedPlateCount();
		greenCount = counter.getGreenPlateCount();
		goldCount = counter.getGoldPlateCount();
		
		System.out.println("Now we should not have any red plates on our belt: " + redCount);
		System.out.println("Now we should not have any green plates on our belt: " + greenCount);
		System.out.println("Now we should not have any gold plates on our belt: " + goldCount);
	
		belt.setPlateAtPosition(gold, 0);
		belt.setPlateAtPosition(gold, 1);
		belt.setPlateAtPosition(gold, 2);
	
		goldCount = counter.getGoldPlateCount();
		System.out.println("We should have 3 gold plates on our belt: " + goldCount);
		
		belt.clearPlateAtPosition(1);
		
		goldCount = counter.getGoldPlateCount();
		System.out.println("Now we should have 2 gold plates on our belt: " + goldCount);
		
		belt.clearPlateAtPosition(0);
		belt.clearPlateAtPosition(1);
		belt.clearPlateAtPosition(2);
		
		//Now we will conduct the exact same type of tests using the setPlateNearestToPosition() 
		//method and the removePlateAtPosition() method. 
		//This should produce identical results.
		System.out.println("\nYou should now expect to see identical output as above.\n");
		belt.setPlateNearestToPosition(red, 0);
		belt.setPlateNearestToPosition(green, 1);
		belt.setPlateNearestToPosition(gold, 2);
		
		redCount = counter.getGoldPlateCount();
		greenCount = counter.getGreenPlateCount();
		goldCount = counter.getGoldPlateCount();
		
		System.out.println("We should have one red plate on our belt: " + redCount);
		System.out.println("We should have one green plate on our belt: " + greenCount);
		System.out.println("We should have one gold plate on our belt: " + goldCount);
		
		belt.removePlateAtPosition(0);
		belt.removePlateAtPosition(1);
		belt.removePlateAtPosition(2);
		
		redCount = counter.getRedPlateCount();
		greenCount = counter.getGreenPlateCount();
		goldCount = counter.getGoldPlateCount();
		
		System.out.println("Now we should not have any red plates on our belt: " + redCount);
		System.out.println("Now we should not have any green plates on our belt: " + greenCount);
		System.out.println("Now we should not have any gold plates on our belt: " + goldCount);
	
		belt.setPlateNearestToPosition(gold, 0);
		belt.setPlateNearestToPosition(gold, 1);
		belt.setPlateNearestToPosition(gold, 2);
	
		goldCount = counter.getGoldPlateCount();
		System.out.println("We should have 3 gold plates on our belt: " + goldCount);
		
		belt.removePlateAtPosition(1);
		
		goldCount = counter.getGoldPlateCount();
		System.out.println("Now we should have 2 gold plates on our belt: " + goldCount);
		
		belt.clearPlateAtPosition(0);
		belt.clearPlateAtPosition(1);
		belt.clearPlateAtPosition(2);
		
		//Test the update method for ProfitCounter
		System.out.println("\nNow moving on to testing the ProfitCounter observer...\n");
		
		belt.setPlateAtPosition(red, 0);
		belt.setPlateAtPosition(green, 1);
		belt.setPlateAtPosition(gold, 2);
		
		double redProfit = red.getProfit();
		double greenProfit = green.getProfit();
		double goldProfit = gold.getProfit();
				
		System.out.println("The profit for the red plate is: " + redProfit);
		System.out.println("The profit for the green plate is: " + greenProfit);
		System.out.println("The profit for the gold plate is: " + goldProfit);
		
		double totalProfitManuallyAdded = redProfit + greenProfit + goldProfit;
		double totalProfitUsingMethod = profit.getTotalBeltProfit();
		double averageManuallyComputed = (redProfit + greenProfit + goldProfit) / 3;
		double averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("The total profit should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("The average profit should be " + averageManuallyComputed + ": " + averageUsingMethod);
		
		belt.clearPlateAtPosition(2);
	
		totalProfitManuallyAdded = redProfit + greenProfit;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = (redProfit + greenProfit) / 2;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed the gold plate and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed the gold plate and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod);

		belt.clearPlateAtPosition(1);
		
		totalProfitManuallyAdded = redProfit;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = redProfit;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed the green plate and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed the green plate and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod);

		belt.clearPlateAtPosition(0);
		
		totalProfitManuallyAdded = 0;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = 0;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed all of the plates and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed all of the plates and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod + "(should say NaN because the method is dividing by zero)");
		
		//Now we will conduct the exact same type of tests using the setPlateNearestToPosition() 
		//method and the removePlateAtPosition() method. 
		//This should produce identical results.
		System.out.println("\nYou should now expect to see identical output as above.\n");

		belt.setPlateNearestToPosition(red, 0);
		belt.setPlateNearestToPosition(green, 1);
		belt.setPlateNearestToPosition(gold, 2);
		
		redProfit = red.getProfit();
		greenProfit = green.getProfit();
		goldProfit = gold.getProfit();
				
		System.out.println("The profit for the red plate is: " + redProfit);
		System.out.println("The profit for the green plate is: " + greenProfit);
		System.out.println("The profit for the gold plate is: " + goldProfit);
		
		totalProfitManuallyAdded = redProfit + greenProfit + goldProfit;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = (redProfit + greenProfit + goldProfit) / 3;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("The total profit should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("The average profit should be " + averageManuallyComputed + ": " + averageUsingMethod);
		
		belt.removePlateAtPosition(2);
	
		totalProfitManuallyAdded = redProfit + greenProfit;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = (redProfit + greenProfit) / 2;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed the gold plate and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed the gold plate and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod);

		belt.removePlateAtPosition(1);
		
		totalProfitManuallyAdded = redProfit;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = redProfit;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed the green plate and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed the green plate and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod);

		belt.removePlateAtPosition(0);
		
		totalProfitManuallyAdded = 0;
		totalProfitUsingMethod = profit.getTotalBeltProfit();
		averageManuallyComputed = 0;
		averageUsingMethod = profit.getAverageBeltProfit();
		
		System.out.println("Now we've removed all of the plates and the total profit for the belt should be " + totalProfitManuallyAdded + ": " + totalProfitUsingMethod);
		System.out.println("Now we've removed all of the plates and the total average for the belt should be " + averageManuallyComputed + ": " + averageUsingMethod + "(should say NaN because the method is dividing by zero)");
		
	}
	
}
