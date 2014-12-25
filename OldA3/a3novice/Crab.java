package a3novice;

public class Crab implements Ingredient {

	private String name = "crab";
	private double amount;
	private double pricePerOunce = 1.50;

	public Crab(double amount) {
		
			this.amount = amount;		
	}
	

	public double getAmount() {
		return amount;
	}

	public double getCost() {
		return pricePerOunce * amount;
	}

	public boolean isRice() {
		return false;
	}


	public boolean isShellFish() {
		return true;
	}

	
	public boolean isVegetarian() {
		return false;
	}

	
	public String getName() {
		return name;
	}
	
	
}

