package comp401.sushi;

@SuppressWarnings("serial")
public class PlatePriceException extends Exception {

	public PlatePriceException() {
		super("Illegal plate price");

	}
}
