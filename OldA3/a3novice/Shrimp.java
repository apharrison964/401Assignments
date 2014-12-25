package a3novice;

public class Shrimp implements Ingredient {

	private String name = "shrimp";
	private double amount;
	private double pricePerOunce = 1.15;

	public Shrimp(double amount) {
		
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


