package orderCard;

@SuppressWarnings("serial")
public class ISBNNumberNotValidException extends Exception {	
	
	public ISBNNumberNotValidException(){
		super("The ISBN number is not valid, it might be negative, or there is a type");
}
}


