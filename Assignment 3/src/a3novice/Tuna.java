package a3novice;


public class Tuna extends IngredientImpl {

	private String name = "tuna";
	private double pricePerOunce = .65;
	
	public Tuna(double amount) {
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
	

