package testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import a7adept.*;
import comp401.sushi.*;

public class AdeptTest {
	Belt belt = new Belt(5);
	GreenPlate green;
	RedPlate red;
	GoldPlate gold;
	
	@Before
	public void setUp() throws Exception {
		Sushi nigiri = new Nigiri(Nigiri.NigiriType.SALMON);
		Sushi sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
		Ingredient[] ingredients = {new Avocado(2), new Crab(2)};
		Sushi roll = new Roll(ingredients);
		
		red = new RedPlate(nigiri);
		green = new GreenPlate(sashimi);
		gold = new GoldPlate(roll, 5);
		
		belt.setPlateAtPosition(red, 0);
		belt.setPlateAtPosition(green, 1);
		belt.setPlateAtPosition(gold, 3);
	}
	
	@Test
	public void initializationTest() {
		assertEquals(0, belt.getAgeOfPlateAtPosition(0));  //red plate
		assertEquals(0, belt.getAgeOfPlateAtPosition(1));  //green plate
		assertEquals(-1, belt.getAgeOfPlateAtPosition(2));
		assertEquals(0, belt.getAgeOfPlateAtPosition(3)); //gold plate
		assertEquals(-1, belt.getAgeOfPlateAtPosition(4));
	}

	@Test
	public void ageTest() throws BeltPlateException, PlatePriceException{
		belt.rotate(); 	
		assertEquals(-1, belt.getAgeOfPlateAtPosition(0)); 
		assertEquals(1, belt.getAgeOfPlateAtPosition(1)); //red plate
		assertEquals(1, belt.getAgeOfPlateAtPosition(2)); //green plate
		assertEquals(-1, belt.getAgeOfPlateAtPosition(3));
		assertEquals(1, belt.getAgeOfPlateAtPosition(4)); //gold plate
		
		belt.setPlateAtPosition(red, 3);
		belt.rotate();
		assertEquals(2, belt.getAgeOfPlateAtPosition(0)); //gold plate
		assertEquals(-1, belt.getAgeOfPlateAtPosition(1));
		assertEquals(2, belt.getAgeOfPlateAtPosition(2)); //red plate
		assertEquals(2, belt.getAgeOfPlateAtPosition(3)); //green plate
		assertEquals(1, belt.getAgeOfPlateAtPosition(4)); //red plate
		
		belt.removePlateAtPosition(2);
		belt.rotate();
		assertEquals(2, belt.getAgeOfPlateAtPosition(0)); //red plate
		assertEquals(3, belt.getAgeOfPlateAtPosition(1)); //gold plate
		assertEquals(-1, belt.getAgeOfPlateAtPosition(2)); 
		assertEquals(-1, belt.getAgeOfPlateAtPosition(3)); 
		assertEquals(3, belt.getAgeOfPlateAtPosition(4)); //green plate
	
	}
	
	@Test
	public void UnwrapTest(){
		assertEquals(red, belt.getPlateAtPosition(0));
		assertEquals(green, belt.getPlateAtPosition(1));
		assertEquals(gold, belt.getPlateAtPosition(3));
		
		assertEquals(red, belt.removePlateAtPosition(0));
		assertEquals(green, belt.removePlateAtPosition(1));
		assertEquals(gold, belt.removePlateAtPosition(3));

	}
	
	private void checkPlateOrder(){  //call to track where each plate is
		for(int i=0;i<belt.getSize();i++){
			if (belt.getPlateAtPosition(i)!=null){
				System.out.println(belt.getPlateAtPosition(i).getColor());
			} else {
				System.out.println("null");
			}
		}
	}

}
