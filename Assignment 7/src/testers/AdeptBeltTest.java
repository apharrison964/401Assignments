package testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comp401.sushi.*;
import comp401.sushi.Sashimi.SashimiType;
import a7adept.Belt;
import a7adept.BeltPlateException;

//Tests that the belt ages plates on rotate()
public class AdeptBeltTest {
	
	public static final int TEST_SIZE = 4;
	
	private Belt belt;
	
	private DecoratedPlateImpl plate;

	@Before
	public void setUp(){
		/* After this method, Belt has size == TEST_SIZE
		 * Plates at positions 1, 2
		 * Others empty
		 */
		// TODO create bew Belt
		
		Belt b = new Belt(4);
		
		// TODO create new Sushi
		
		Sashimi testSus = new Sashimi(SashimiType.EEL);
		
		// TODO put Sushi on Plates
		
		try {
			plate = (DecoratedPlateImpl) new RedPlate(testSus);
		} catch (PlatePriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO put plates on Belt
		
	   try {
		belt.setPlateAtPosition((Plate) plate, 0);
	} catch (BeltPlateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	// TODO test initialization
	@Test
	public void initTest(){
		assertEquals(-1, belt.getAgeOfPlateAtPosition(0));
		assertEquals(0, belt.getAgeOfPlateAtPosition(0));
		assertEquals(0, belt.getAgeOfPlateAtPosition(0));
		assertEquals(-1, belt.getAgeOfPlateAtPosition(0));
	}
	
	// TODO rotate Belt and test age
		@Test
		public void ageTest(){
			for(int i = 0; i < TEST_SIZE; i++){
				belt.rotate();  //executes TEST_SIZE times
			}
			assertEquals(-1, belt.getAgeOfPlateAtPosition(0));
			assertEquals(TEST_SIZE, belt.getAgeOfPlateAtPosition(0));
			assertEquals(TEST_SIZE, belt.getAgeOfPlateAtPosition(0));
			assertEquals(-1, belt.getAgeOfPlateAtPosition(0));
			// TODO add new plates with age == 0 after rotating

		}
}
