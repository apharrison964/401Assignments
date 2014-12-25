package orderCard;

@SuppressWarnings("serial")
public class EditionException extends Exception {
	public EditionException(){
		super("The edition must be a year");
	}
}
