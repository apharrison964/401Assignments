package a4;

public class GoldPlate extends PlateImpl {

	public GoldPlate(Sushi contents, double price) throws PlatePriceException {
		super(contents, price, Color.GOLD);
		if (price < 5.0) {
			throw new IllegalArgumentException();
		}
	}

}
