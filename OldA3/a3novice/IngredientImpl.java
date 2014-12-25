package a3novice;

abstract public class IngredientImpl implements Ingredient {
	
	private double pricePerOunce;
	private String name;
	private double amount;
	
	IngredientImpl(double pricePerOunce, String name, double amount){
		
		this.pricePerOunce = pricePerOunce;
		this.name = name;
		this.amount = amount;
		}
	
	public double getCost(){
		return pricePerOunce * amount;
	}

	public String getName(){
		return name;
	}
	
	public double getAmount(){
		return amount;
	}
}
		
