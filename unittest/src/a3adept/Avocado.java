package a3adept;


public class Avocado extends IngredientImpl {

	private String name = "avocado";
	private double pricePerOunce = .80;
	
	public Avocado(double amount) {
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
	

