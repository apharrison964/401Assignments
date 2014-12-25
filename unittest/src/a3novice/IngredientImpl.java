package a3novice;


abstract public class IngredientImpl implements Ingredient {
	
	private double amount;
	
	IngredientImpl(double amount){
		this.amount = amount;
		if(amount < 0){
			throw new RuntimeException("Not a valid input for the amount");
		}
		
		}
	

	public double getAmount(){
		return amount;
	}
}
		
