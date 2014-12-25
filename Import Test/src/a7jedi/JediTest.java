package a7jedi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comp401.sushi.*;
import a7jedi.*;

public class JediTest {

	Belt belt = new Belt(5);
	GreenPlate green;
	RedPlate red;
	GoldPlate gold;
	BluePlate blue;
	RedPlate empty;
	ProfitCounter profit_counter = new ProfitCounter();
	PlateCounter plate_counter = new PlateCounter();
	SpoilageCollector spoil_counter = new SpoilageCollector();

	@Before
	public void setUp() throws Exception {
		Sushi nigiri = new Nigiri(Nigiri.NigiriType.SALMON);
		Sushi sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
		Ingredient[] ingredients = {new Avocado(2), new Crab(2)};
		Sushi roll = new Roll(ingredients);
		Ingredient[] ingredients2 = {new Avocado(1), new Seaweed(1), new Rice(1)};
		Sushi roll2 = new Roll(ingredients2);

		red = new RedPlate(nigiri);
		green = new GreenPlate(sashimi);
		gold = new GoldPlate(roll, 5);
		blue = new BluePlate(roll2);
		empty = new RedPlate(null);

		belt.addObserver(profit_counter);
		belt.addObserver(plate_counter);
		belt.addObserver(spoil_counter);

		belt.setPlateAtPosition(red, 0);
		belt.setPlateAtPosition(green, 1);
		belt.setPlateAtPosition(empty, 2);
		belt.setPlateAtPosition(gold, 3);
		belt.setPlateAtPosition(blue, 4);
	}

	@Test
	public void SpoilTest(){
		for (int i=0;i<belt.getSize()-1;i++){
			belt.rotate(); 
		}
		//1 less than full rotation

		assertEquals(0, spoil_counter.getTotalSpoiledCost(), .01);
		assertEquals(0, spoil_counter.getTotalSpoiledShellfish(), .01);
		assertEquals(0, spoil_counter.getTotalSpoiledSeafood(), .01);
		assertEquals(0, spoil_counter.getTotalSpoiledFood(), .01);

		belt.rotate(); //full rotation 1

		assertEquals(4.6, spoil_counter.getTotalSpoiledCost(), .01);
		assertEquals(2, spoil_counter.getTotalSpoiledShellfish(), .01);
		assertEquals(2, spoil_counter.getTotalSpoiledSeafood(), .01);
		assertEquals(4, spoil_counter.getTotalSpoiledFood(), .01);
		assertNull(belt.getPlateAtPosition(3));

		for (int i=0;i<belt.getSize();i++){
			belt.rotate(); 
		} //full rotation 2

		assertEquals(5.775, spoil_counter.getTotalSpoiledCost(), .01);
		assertEquals(2, spoil_counter.getTotalSpoiledShellfish(), .01);
		assertEquals(3.5, spoil_counter.getTotalSpoiledSeafood(), .01);
		assertEquals(6, spoil_counter.getTotalSpoiledFood(), .01);
		assertNull(belt.getPlateAtPosition(0));
		assertNull(belt.getPlateAtPosition(1));

		for (int i=0;i<belt.getSize();i++){
			belt.rotate(); 
		} //full rotation 3

		assertEquals(7.225, spoil_counter.getTotalSpoiledCost(), .01);
		assertEquals(2, spoil_counter.getTotalSpoiledShellfish(), .01);
		assertEquals(3.5, spoil_counter.getTotalSpoiledSeafood(), .01);
		assertEquals(9, spoil_counter.getTotalSpoiledFood(), .01);
		assertNull(belt.getPlateAtPosition(4));

		for (int i=0;i<belt.getSize();i++){
			belt.rotate(); 
		} //full rotation 4

		assertEquals(7.225, spoil_counter.getTotalSpoiledCost(), .01);
		assertEquals(2, spoil_counter.getTotalSpoiledShellfish(), .01);
		assertEquals(3.5, spoil_counter.getTotalSpoiledSeafood(), .01);
		assertEquals(9, spoil_counter.getTotalSpoiledFood(), .01);
	}

	@Test
	public void OtherCountersTest() throws BeltPlateException {
		assertEquals(2, plate_counter.getRedPlateCount());
		assertEquals(.955, profit_counter.getAverageBeltProfit(), .01);

		belt.removePlateAtPosition(0);
		belt.removePlateAtPosition(3);
		assertEquals(1, plate_counter.getRedPlateCount());
		assertEquals(0, plate_counter.getGoldPlateCount());
		assertEquals(1.354166666, profit_counter.getAverageBeltProfit(), .01);

		belt.setPlateAtPosition(red,0);
		belt.setPlateAtPosition(gold,3);
		assertEquals(2, plate_counter.getRedPlateCount());
		assertEquals(1, plate_counter.getGoldPlateCount());
		assertEquals(.955, profit_counter.getAverageBeltProfit(), .01);
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