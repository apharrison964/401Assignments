package comp401.sushi;

public class Sashimi implements Sushi {
	
	static private double amount = .75;
	private Ingredient[] ingredient = new Ingredient[1];
	private SashimiType type;
	
	
	public enum SashimiType {TUNA, SALMON, EEL, CRAB, SHRIMP};

	public Sashimi(SashimiType type) {
		this.type = type;
		switch(type){
			case TUNA:
				ingredient[0] = (new Tuna(amount));
				break;
			case SALMON:
				ingredient[0] = (new Salmon(amount));
				break;
			case EEL:
				ingredient[0] = (new Eel(amount));
				break;
			case CRAB:
				ingredient[0] = (new Crab(amount));
				break;
			case SHRIMP:
				ingredient[0] = (new Shrimp(amount));
				break;
		}
	
	}
	
	@Override
	public boolean hasRice() {
		return false;
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

	@Override
	public double getCost() {
		return ingredient[0].getCost();
	}
	
	@Override
	public Ingredient[] getIngredients() {
		return ingredient;
	}
	
}

