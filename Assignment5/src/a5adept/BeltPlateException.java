package a5adept;

import comp401.sushi.Plate;

@SuppressWarnings("serial")
public class BeltPlateException extends Exception {

	private int position;
	private Plate plateToBeSet;
	private Belt belt;

	public BeltPlateException(int position, Plate plate_to_be_set, Belt belt) {
		super("There was an error trying to place the plate on the belt");
		this.position = position;
		this.belt = belt;
		this.plateToBeSet = plate_to_be_set;
	}

	public int getPosition() {
		return position;

	}

	public Plate getPlateToSet() {
		return plateToBeSet;

	}

	public Belt getBelt() {
		return belt;

	}

}
