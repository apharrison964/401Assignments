package a3novice;

public class Salmon implements Ingredient {

	private String name = "salmon";
	private double amount;
	private double pricePerOunce = 0.75;

	public Salmon(double amount) {
		
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
		return false;
	}

	
	public String getName() {
		return name;
	}
	
	
}

