package orderCard;

@SuppressWarnings("serial")
public class ISBNNumberGreaterException extends Exception {	
	
	public ISBNNumberGreaterException(){
		super("The ISBN number is greater than 13 digits");
}
}


