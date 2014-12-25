package comp401.sushi;

/**
 * Common interface for sushi ingredients
 * @author KMP
 */

public interface Ingredient {
	/**
	 * Standard getter fot the amount of ingredients
	 * @return the amount in unit ounce
	 */
    double getAmount();
    /**
     * Standard getter for the cost of ingredient
     * @return the cost of the ingredient
     */
    double getCost();
    /**
     * Standard getter
     * @return cost
     */
    boolean isRice();
    /**
     * Standard Boolean getter
     * @return whether the ingredient is rice
     */
    boolean isShellfish();
    /**
     * Standard Boolean getter
     * @return whether the ingredient is shellfish
     */
    boolean isVegetarian();
    /**
     * Standard Boolean getter
     * @return whether the ingredient is vegetarian
     */
    String getName();
    /**
     * Standard  getter
     * @return name
     */
}
