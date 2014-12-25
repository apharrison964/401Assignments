package a5adept;

import java.util.Iterator;
import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class BeltIterator implements Iterator<Plate> {

	private Belt belt;
	private int start_position;

	public BeltIterator(Belt belt, int start_position) {
		this.belt = belt;
		this.start_position = start_position;
	}

	@Override
	public boolean hasNext() {
		
		Plate testForNextPlate = belt.getPlateAtPosition(start_position);
		
		if(testForNextPlate != null){
			return true;
			
		} else {
			
			for(int i = 0; i < belt.getSize(); i++){
				
				start_position++;
				
				testForNextPlate = belt.getPlateAtPosition(start_position);
				
				if(testForNextPlate != null){
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public Plate next() {
		
		int size = belt.getSize();
		
		if (!hasNext()) {
			throw new NoSuchElementException();
			
		} else {
			for (int i = 0; i < belt.getSize(); i++) {
				
				if (start_position < 0) {
					start_position = (((start_position % size) + size) % size);
					
				} else {
					start_position = (start_position % size);
				} 
				
				Plate nextPlate = belt.getPlateAtPosition(start_position);
				start_position++;
				
				if (nextPlate != null) {
					return nextPlate;
				}
			}
		}
		throw new RuntimeException();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
