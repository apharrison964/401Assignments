package a7adept;

import comp401.sushi.*;

public class DecoratedPlateImpl implements DecoratedPlate {
	private Plate wrappedPlate;
	private int rotationCount;

	public DecoratedPlateImpl(Plate p, int rotationCount){
		wrappedPlate = p;
		this.rotationCount = rotationCount;
	}

	public Plate getWrappedPlate(){
		return this.wrappedPlate;
	}

	@Override
	public Sushi getContents() {
		return wrappedPlate.getContents();
	}

	@Override
	public Sushi removeContents() {
		return wrappedPlate.removeContents();
	}

	@Override
	public void setContents(Sushi s) throws PlatePriceException {
		wrappedPlate.setContents(s);
	}

	@Override
	public boolean hasContents() {
		return wrappedPlate.hasContents();
	}

	@Override
	public double getPrice() {
		return wrappedPlate.getPrice();
	}

	@Override
	public Color getColor() {
		return wrappedPlate.getColor();
	}

	@Override
	public double getProfit() {
		return wrappedPlate.getProfit();
	}

	@Override
	public int rotationCount() {
		return rotationCount;
	}

	public int getAge(int passedCount){
		return passedCount - rotationCount;
	}
}

