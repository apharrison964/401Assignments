package a3novice;

public class Avocado implements Ingredient {

	private String name = "avocado";
	private double amount;
	private double pricePerOunce = 0.80;

	public Avocado(double amount) {
		
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

