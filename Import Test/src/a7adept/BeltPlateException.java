package a7adept;

import comp401.sushi.Plate;

@SuppressWarnings("serial")
public class BeltPlateException extends Exception {

	private int position;
	private Plate plate_to_set;
	private Belt belt;

	public BeltPlateException(int position, Plate plate, Belt belt) {
		super("Attempt to set belt position that is already occupied");
		this.position = position;
		this.plate_to_set = plate;
		this.belt = belt;
	}

	public int getPosition() {
		return position;
	}

	public Plate getPlateToSet() {
		return plate_to_set;
	}

	public Belt getBelt() {
		return belt;
	}

}
