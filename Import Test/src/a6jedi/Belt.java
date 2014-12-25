package a6jedi;

import java.util.NoSuchElementException;
import java.util.Observable;
import a6jedi.PlateEvent.EventType;

import comp401.sushi.Plate;

public class Belt extends Observable {

	private Plate[] belt;
	private Customer[] customer;

	public Belt(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		belt = new Plate[size];
		customer = new Customer[belt.length];
	}

	public int getSize() {
		return belt.length;
	}

	public Plate getPlateAtPosition(int position) {
		position = correct_position(position);
		return belt[position];
	}

	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}
		else if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		} 
		else {
			belt[correct_position(position)] = plate; 
		}
		setChanged();
		notifyObservers(new PlateEvent(EventType.PLATE_PLACED, plate, position));
	}

	public void clearPlateAtPosition(int position) {
		Plate plateStorage = belt[correct_position(position)];
		belt[correct_position(position)] = null;
		setChanged();
		notifyObservers(new PlateEvent(EventType.PLATE_REMOVED, plateStorage, position));
	}

	public Plate removePlateAtPosition(int position) {
		Plate plate_at_position = getPlateAtPosition(position);

		if (plate_at_position == null) {
			throw new NoSuchElementException();
		}
		clearPlateAtPosition(position);
		return plate_at_position;
	}

	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		position = correct_position(position);

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
		Plate last_plate = belt[getSize() - 1];

		for (int i = getSize() - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = last_plate;

		for(int i = 0; i < customer.length; i++){
			if(belt[i] != null && customer[i] != null){
				customer[i].observePlateOnBelt(this, belt[i], i);
			}
		}
	}

	private int correct_position(int position) {
		if (position < 0) {
			return ((position % getSize()) + getSize()) % getSize();
		}
		return position % getSize();
	}

	public void registerCustomerAtPosition(Customer c, int position){
		int correctPos = correct_position(position);

		if(customer[correctPos] != null){
			throw new RuntimeException();
		} 
		else {
			for(int i = 0; i < customer.length; i++){
				if(customer[i] == c){
					throw new RuntimeException();
				}
			}
		}
		customer[correctPos] = c;
	}

	public Customer unregisterCustomerAtPosition(int position){
		Customer c1 = customer[position];

		if(customer[position] == null){
			return null;
		} else {
			customer[position] = null;
			return c1;
		}
	}
}
