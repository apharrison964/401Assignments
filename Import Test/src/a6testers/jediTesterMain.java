package a6testers;

import comp401.sushi.*;

import java.util.NoSuchElementException;

import a6jedi.Belt;
import a6jedi.BeltFullException;
import a6jedi.BeltPlateException;
import a6jedi.Customer;

public class jediTesterMain {

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
		
		belt.setPlateAtPosition(red, 0);
		belt.setPlateAtPosition(green, 1);
		belt.setPlateAtPosition(gold, 2);
		
		System.out.println("Testing the Customer observer...\n");
		
		CustomerImpl Mike = new CustomerImpl();
		CustomerImpl Nicole = new CustomerImpl();
		CustomerImpl Jane = new CustomerImpl();
		
		belt.registerCustomerAtPosition(Mike, 0);
		belt.registerCustomerAtPosition(Nicole, 1);
		belt.registerCustomerAtPosition(Jane, 5);
		
		System.out.println("The belt started off with a Red, Green, and Gold plate (in that order).");
		System.out.println("The following output should reflect them rotating through 3 times.\n");
		
		belt.rotate();
		belt.rotate();
		belt.rotate();
		
		CustomerImpl Daniel = new CustomerImpl();
		
		//Try to register a customer where there is already one
		try {
			belt.registerCustomerAtPosition(Daniel, 0); 
			System.out.println("We should never get here; we should have thrown an exception");
		}
		catch (RuntimeException e){
			System.out.println("We caught a RuntimeException.");
		} 
		
		Customer c = belt.unregisterCustomerAtPosition(2);
		if (c == Jane) {
			System.out.println("We just unregistered Jane.");
		}
		else {
			System.out.println("Had a problem unregistering Jane.");
		}
		
		//Try to register the same customer somewhere 
		try {
			belt.registerCustomerAtPosition(Mike, 2);
			System.out.println("We should never get here; we should have thrown an exception");
		}
		catch (RuntimeException e){
			System.out.println("We caught a RuntimeException.");
		} 
		
		belt.unregisterCustomerAtPosition(1);
		
		System.out.println("We unregistered all but one costumer; now we should only see plates rotating through one index.");
		
		belt.rotate();
		belt.rotate();
		belt.rotate();
	}
}

