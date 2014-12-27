package a3adept;


public class Rice extends IngredientImpl {

	private String name = "rice";
	private double pricePerOunce = .25;
	
	public Rice(double amount) {
		super(amount);
		
	}

	public boolean isRice() {
		return true;
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
	

