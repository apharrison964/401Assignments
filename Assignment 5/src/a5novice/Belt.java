package a5novice;

import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class Belt {

	private int size;
	private Plate[] plateArray;

	public Belt(int size) {
		this.size = size;
		
		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		
		plateArray = new Plate[size];
	 }

	public int getSize() {
		return size;
	 }

	public Plate getPlateAtPosition(int position) {
		if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
		}
		
		return plateArray[position];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {

		if (plate == null) {
			throw new IllegalArgumentException();
			
		} else if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
			
		} else if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		plateArray[position] = plate;

	}

	public void clearPlateAtPosition(int position) {
		if (position < 0 || position > getSize() - 1) {
			throw new IllegalArgumentException();
		}
		
		plateArray[position] = null;
	}

	public Plate removePlateAtPosition(int position) {

		Plate removePlate = getPlateAtPosition(position);

		if (removePlate == null) {
			throw new NoSuchElementException();
			
		} else {
			clearPlateAtPosition(position);
			return removePlate;
		}
	}
}
