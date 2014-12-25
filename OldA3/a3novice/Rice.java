package a3novice;

public class Rice implements Ingredient {

	private String name = "rice";
	private double amount;
	private double pricePerOunce = 0.25;

	public Rice(double amount) {
		
			this.amount = amount;		
	}
	

	public double getAmount() {
		return amount;
	}

	public double getCost() {
		return pricePerOunce * amount;
	}

	public boolean isRice() {
		return true;
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

