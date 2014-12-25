package a7adept;

import java.util.NoSuchElementException;
import java.util.Observable;

import a7adept.PlateEvent.EventType;
import comp401.sushi.Plate;

public class Belt extends Observable {

	DecoratedPlateImpl[] belt;
	int rotationCount;
	int age;
	DecoratedPlateImpl plateDec;

	public Belt(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		belt = new DecoratedPlateImpl[size];
		rotationCount = 0;
		age = 0;
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		if(belt[correctPosition(position)] == null){
			return null;
		}
		
		return belt[correctPosition(position)].getWrappedPlate();
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		plateDec = new DecoratedPlateImpl(plate, this.rotationCount);

		if(plate == null){
			throw new IllegalArgumentException();
		}

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} 
		
		else {
			belt[correctPosition(position)] = plateDec; 

			setChanged();
			notifyObservers(new PlateEvent(EventType.PLATE_PLACED, plate, position));
		}
	}

	public void clearPlateAtPosition(int position) {

		if(this.getPlateAtPosition(position) != null){
			PlateEvent event = new PlateEvent(EventType.PLATE_REMOVED, this.getPlateAtPosition(position), position);
			this.notifyObservers(event);
		}

		belt[correctPosition(position)] = null;

	}

	public Plate removePlateAtPosition(int position) {
		Plate plateAtPosition = getPlateAtPosition(position);
		if(plateAtPosition == null){
			throw new NoSuchElementException();
		}
		
		clearPlateAtPosition(position);
		return plateAtPosition;
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		position = correctPosition(position);

		for (int offset = 0; offset < getSize(); offset++) {
			try {
				setPlateAtPosition(plate, position + offset);
				return position + offset;
			}
			
			catch (BeltPlateException e) {
				
			}
		}
		
		throw new BeltFullException(this);
	}

	public void rotate() {
		DecoratedPlateImpl lastPlate = belt[getSize()-1];

		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}

		belt[0] = lastPlate;
		rotationCount++;
	}

	private int correctPosition(int position) {
		if (position < 0) {
			return ((position % getSize()) + getSize()) % getSize();
		}
		
		return position % getSize();
	}

	public int getAgeOfPlateAtPosition(int position) {
		if(this.getPlateAtPosition(position) == null){
			age = -1;
		} else {
			age = rotationCount - belt[position].rotationCount();
		}
		
		return age;
	}


}
