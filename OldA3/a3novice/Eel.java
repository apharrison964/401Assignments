package a3novice;

public class Eel implements Ingredient {

	private String name = "eel";
	private double amount;
	private double pricePerOunce = 1.25;

	public Eel(double amount) {
		
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

