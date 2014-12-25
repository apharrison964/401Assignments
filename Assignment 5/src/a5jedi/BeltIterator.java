package a5jedi;

import java.util.Iterator;
import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private double max_price;
	private int position;
	private Plate.Color color_filter;
	private boolean removeAvailable = false;
	private enum BeltItType {REGULAR, WITH_PRICE, WITH_COLOR};
	private BeltItType beltItType;
	

	// Helper method to determine what BeltIterator is being used
	private boolean criteriaMet(Plate plate) {
		boolean criteriaMet = false;
		
		if (plate == null) {
			return false;
		}
		
		switch (beltItType) {
		
		case REGULAR:
			criteriaMet = true;
			break;
			
		case WITH_COLOR:
			criteriaMet = plate.getColor() == color_filter;
			break;
			
		case WITH_PRICE:
			criteriaMet = plate.getPrice() <= max_price;
			break;
		}
		return criteriaMet;
	}

	public BeltIterator(Belt belt, int start_position) {
		beltItType = BeltItType.REGULAR;
		this.belt = belt;
		this.position = start_position;
	}

	public BeltIterator(Belt belt, int start_position, double max_price) {
		beltItType = BeltItType.WITH_PRICE;
		this.belt = belt;
		this.position = start_position;
		this.max_price = max_price;
	}


	public BeltIterator(Belt belt, int start_position, Plate.Color color_filter) {
		beltItType = BeltItType.WITH_COLOR;
		this.belt = belt;
		this.position = start_position;
		this.color_filter = color_filter;
	}

	@Override
	public boolean hasNext() {
		
		Plate plateTest = belt.getPlateAtPosition(position);
		
		if(plateTest != null && criteriaMet(plateTest)){
			return true;
			
		} else {
			
			for(int i = 0; i < belt.getSize(); i++){
				
				plateTest = belt.getPlateAtPosition(position + i);

				if(plateTest != null && criteriaMet(plateTest)){
					position = position + i;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Plate next() {
		
		if (!hasNext()) {
			throw new NoSuchElementException();
			
		} else {
			Plate nextPlate = belt.getPlateAtPosition(position);
			position++;
			removeAvailable = true;
			
			return nextPlate;
		}
	}

	@Override
	public void remove() {
		if (!removeAvailable) {
			throw new IllegalStateException();
			
		} else {
			position--;
			belt.removePlateAtPosition(position);
			removeAvailable = false;
		}
	}
}
