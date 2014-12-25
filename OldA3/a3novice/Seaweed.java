package a3novice;

public class Seaweed implements Ingredient {

	private String name = "seaweed";
	private double amount;
	private double pricePerOunce = 0.40;

	public Seaweed(double amount) {
		
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
		return false;
	}

	
	public boolean isVegetarian() {
		return true;
	}

	
	public String getName() {
		return name;
	}
	
	
}

