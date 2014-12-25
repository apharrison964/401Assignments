package a3jedi;


public class Shrimp extends IngredientImpl {

	private String name = "shrimp";
	private double pricePerOunce = 1.15;
	
	public Shrimp(double amount) {
		super(amount);
		
	}

	public boolean isRice() {
		return false;
	}

	public boolean isShellfish() {
		return true;
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
	

