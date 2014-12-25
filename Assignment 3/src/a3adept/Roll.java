package a3adept;

public class Roll implements Sushi{
	
	private Ingredient[] roll_ingredients;
	private Ingredient[] newRollIngredients;

	public Roll(Ingredient[] roll_ingredients){
		
		this.roll_ingredients = roll_ingredients.clone();
		
	}
	
	@Override
	public Ingredient[] getIngredients() {
		newRollIngredients = roll_ingredients.clone();
		return newRollIngredients;
	}

	@Override
	public double getCost() {
		double cost = 0;
		for(int i = 0; i < roll_ingredients.length; i++){
			cost += roll_ingredients[i].getCost();
		}
		return cost;
	}

	@Override
	public boolean hasRice() {
		boolean rice = false;
		for(int i = 0; i < roll_ingredients.length; i++){	
			rice = roll_ingredients[i].isRice();
			if(rice == true){
				break;
			}
		}
		
		return rice;
	}

	@Override
	public boolean hasShellfish() {
		
		boolean shellfish = false;
		for(int i = 0; i < roll_ingredients.length; i++){
			shellfish = roll_ingredients[i].isShellfish();
			if(shellfish == true){
				break;
			}
		}
		
		return shellfish;
	}

	@Override
	public boolean isVegetarian() {
		boolean vegetarian = false;
		for(int i = 0; i < roll_ingredients.length; i++){
			vegetarian = roll_ingredients[i].isVegetarian();
			if(vegetarian == false){
				break;
			}
		}
		return vegetarian;
	

	}
}

	
