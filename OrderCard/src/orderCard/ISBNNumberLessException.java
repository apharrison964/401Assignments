package orderCard;

@SuppressWarnings("serial")
public class ISBNNumberLessException extends Exception {	
	
	public ISBNNumberLessException(){
		super("The ISBN number is less than 13 digits");
}
}


