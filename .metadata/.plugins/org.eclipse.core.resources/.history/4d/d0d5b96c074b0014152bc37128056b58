package a4;


public class Seaweed extends IngredientImpl {

	private String name = "seaweed";
	private double pricePerOunce = .40;
	
	public Seaweed(double amount) {
		super(amount);
		
	}

	public boolean isRice() {
		return false;
	}

	public boolean isShellfish() {
		return false;
	}

	public boolean isVegetarian() {
		return true;
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
	

