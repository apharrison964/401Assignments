package comp401.sushi;

import java.util.ArrayList;

public class Roll implements Sushi {

	private Ingredient[] list;
	
	public Roll(Ingredient[] roll_ingredients) {
		ArrayList<Ingredient> newList = new ArrayList<Ingredient>();

		for (int i = 0; i < roll_ingredients.length; i++) {
			if (roll_ingredients[i] == null) {
				throw new RuntimeException("No roll ingredients detected");
			}
		}
		for (Ingredient originalIng : roll_ingredients) {

			boolean found_duplicate = false;
			for (int newIng = 0; newIng < newList.size(); newIng++) {

				if (originalIng.getName().equals(newList.get(newIng).getName())) {
					found_duplicate = true; 
					double combine = originalIng.getAmount() + newList.get(newIng).getAmount();					

					switch (originalIng.getName()) {

					case "avocado":
						newList.set(newIng, new Avocado(combine));
						break;

					case "crab":
						newList.set(newIng, new Crab(combine));
						break;

					case "eel":
						newList.set(newIng, new Eel(combine));
						break;

					case "rice":
						newList.set(newIng, new Rice(combine));
						break;

					case "salmon":
						newList.set(newIng, new Salmon(combine));
						break;

					case "seaweed":
						newList.set(newIng, new Seaweed(combine)); 
						break;

					case "shrimp":
						newList.set(newIng, new Shrimp(combine)); 
						break;

					case "tuna":
						newList.set(newIng, new Tuna(combine)); 
						break;
					}
					break;
				}
			}
			if (!found_duplicate) {
				newList.add(originalIng);
			}
		}
	
		
	  boolean foundSeaweed = false;
	  	for(Ingredient i : newList){
	  		if(i.getName().equals("seaweed")){
	  			foundSeaweed = true;
	  			if(i.getAmount() < 0.1){
	  				newList.remove(i);
	  				newList.add(new Seaweed(0.1));
	  			}
	  			break;
	  		}
	  	}
	  	if(!foundSeaweed){ 
	  		newList.add(new Seaweed(0.1));
	  	}
		
		  list = newList.toArray(new Ingredient[newList.size()]);
		

	}

	@Override
	public Ingredient[] getIngredients() {

		return list.clone();
	}

	@Override
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < list.length; i++) {
			cost += list[i].getCost();
		}
		return cost;
	}

	@Override
	public boolean hasRice() {
		boolean rice = false;
		for (int i = 0; i < list.length; i++) {
			rice = list[i].isRice();
			if (rice == true) {
				break;
			}
		}

		return rice;
	}
 
	@Override
	public boolean hasShellfish() {

		boolean shellfish = false;
		for (int i = 0; i < list.length; i++) {
			shellfish = list[i].isShellfish();
			if (shellfish == true) {
				break;
			}
		}

		return shellfish;
	}

	@Override
	public boolean isVegetarian() {
		boolean vegetarian = false;
		for (int i = 0; i < list.length; i++) {
			vegetarian = list[i].isVegetarian();
			if (vegetarian == false) {
				break;
			}
		}
		return vegetarian;

	}
}
