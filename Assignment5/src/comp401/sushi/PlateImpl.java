package comp401.sushi;

abstract public class PlateImpl implements Plate {

	private Sushi contents;
	private double price;
	private Color color;

	public PlateImpl(Sushi contents, double price, Color color)
			throws PlatePriceException {
		this.contents = contents;
		this.price = price;
		this.color = color;

		if (contents == null) {
			contents = null;
		} else if (price <= contents.getCost()) {
			throw new PlatePriceException();
		} else {
			this.contents = contents;
		}
	}

	@Override
	public Sushi getContents() {

		if (contents == null) {
			return null;
		} else {
			return contents;
		}
	}

	@Override
	public Sushi removeContents() {
		if (contents == null) {
			return contents;
		} else {
			Sushi i = contents;
			contents = null;
			return i;
		}
	}

	public double getPrice() {
		return price;

	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		if (s == null) {
			throw new IllegalArgumentException("There's nothing on the plate!");
		} else if (price <= s.getCost()) {
			throw new PlatePriceException();
		} else {
			contents = s;
		}
	}

	@Override
	public boolean hasContents() {
		return contents != null;
	}

	public Plate.Color getColor() {
		return color;
	}

	public double getProfit() {
		if (contents == null) {
			return 0.0;
		} else {
			return price - contents.getCost();
		}
	}

}
