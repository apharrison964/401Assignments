package a5adept;

import java.util.Iterator;
import java.util.NoSuchElementException;

import comp401.sushi.Plate;

public class Belt implements Iterable<Plate> {

	private int size;
	private int position;
	private Plate[] plateArray;

	public Belt(int size) {
		this.size = size;

		if (size <= 0) {
			throw new IllegalArgumentException();
		}
		plateArray = new Plate[size];
	}

	private int modOperations(int position) {

		if (position < 0) {
			position = (((position % size) + size) % size);

		} else {
			position = (position % size);
		}
		return position;

	}

	public int getSize() {
		return size;
	}

	public Plate getPlateAtPosition(int position) {
		return plateArray[modOperations(position)];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {

		position = modOperations(position);

		if (plate == null) {
			throw new IllegalArgumentException();

		} else if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);

		}

		plateArray[position] = plate;
	}

	public void clearPlateAtPosition(int position) {

		position = modOperations(position);
		plateArray[position] = null;
	}

	public Plate removePlateAtPosition(int position) {

		position = modOperations(position);
		Plate removePlate = getPlateAtPosition(position);

		if (removePlate == null) {
			throw new NoSuchElementException();
		} else {
			clearPlateAtPosition(position);
			return removePlate;
		}
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {

		position = modOperations(position);

		for (int i = 0; i < plateArray.length; i++) {
			int j = position + i;

			if (j < 0) {
				j = ((j % size) + size) % size;
			} else {
				j = j % size;
			}
			if (plateArray[j] == null) {
				plateArray[j] = plate;
				return j;
			}
		}
		throw new BeltFullException(this);
	}

	@Override
	public Iterator<Plate> iterator() {
		position = modOperations(position);
		return new BeltIterator(this, position);

	}

	public Iterator<Plate> iteratorFromPosition(int position) {

		position = modOperations(position);
		return new BeltIterator(this, position);

	}

	public void rotate() {

		Plate[] tempArray = new Plate[size];

		for (int i = 0; i <= size - 1; i++) {
			if (i == 0) {
				tempArray[i] = plateArray[size - 1];

			} else {
				tempArray[i] = plateArray[i - 1];
			}
		}

		plateArray = tempArray.clone();
	}

}
