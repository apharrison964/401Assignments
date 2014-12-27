package a3adept;


public class Crab extends IngredientImpl {

	private String name = "crab";
	private double pricePerOunce = 1.50;
	
	public Crab(double amount) {
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
	

