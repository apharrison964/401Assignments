package a3jedi;


public class Nigiri implements Sushi {

	
	static private double amountSeafood = .75;
	static private double amountRice = .50;
	private Ingredient[] ingredient = new Ingredient[2];
	private NigiriType type;
	
	
	public enum NigiriType {TUNA, SALMON, EEL, CRAB, SHRIMP};

	public Nigiri(NigiriType type) {
		this.type = type;
		
		switch(type){
			case TUNA:
				ingredient[0] = (new Tuna(amountSeafood));
				ingredient[1] = (new Rice(amountRice));
				break;
			case SALMON:
				ingredient[0] = (new Salmon(amountSeafood));
				ingredient[1] = (new Rice(amountRice));
				break;
			case EEL:
				ingredient[0] = (new Eel(amountSeafood));
				ingredient[1] = (new Rice(amountRice));
				break;
			case CRAB:
				ingredient[0] = (new Crab(amountSeafood));
				ingredient[1] = (new Rice(amountRice));
				break;
			case SHRIMP:
				ingredient[0] = (new Shrimp(amountSeafood));
				ingredient[1] = (new Rice(amountRice));
				break;
		}
	
	}
	
	@Override
	public Ingredient[] getIngredients() {
		return ingredient;
	}

	@Override
	public double getCost() {
		return (ingredient[0].getCost()) + 
				(ingredient[1].getCost());
	}

	@Override
	public boolean hasRice() {
		return true;
	}

	@Override
	public boolean hasShellfish() {
		switch(type){
		case TUNA:
			return false;
			
		case SALMON:
			return false;
		case EEL:
			return false;
			
		case CRAB:
			return true;
			
		case SHRIMP:
			return true;
			
		default: return false;
		}
	}

	@Override
	public boolean isVegetarian() {
		return false;
	}


}
