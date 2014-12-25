package a4;


public class Salmon extends IngredientImpl {

	private String name = "salmon";
	private double pricePerOunce = .75;
	
	public Salmon(double amount) {
		super(amount);
		
	}

	public boolean isRice() {
		return false;
	}

	public boolean isShellfish() {
		return false;
	}

	public boolean isVegetarian() {
		return false;
	}

	@Override
	public double getCost() {
		return pricePerOunce * getAmount();
	}

	@Override
	public String getName() {
		return name;
	}


}
	

