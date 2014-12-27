package a3adept;


public class Eel extends IngredientImpl {

	private String name = "eel";
	private double pricePerOunce = 1.25;
	
	public Eel(double amount) {
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
	

