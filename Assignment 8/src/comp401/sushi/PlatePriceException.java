package comp401.sushi;

public class PlatePriceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlatePriceException() {
		super("Contents of plate can not cost more than price of plate");
	}
}
