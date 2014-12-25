package a3novice;

public class Tuna extends IngredientImpl implements Ingredient {


	Tuna(double amount, double pricePerOunce, String name) {
		super(amount, name, pricePerOunce);		
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
	


	
}

