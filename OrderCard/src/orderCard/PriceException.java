package orderCard;

@SuppressWarnings("serial")
public class PriceException extends Exception{	
	
	public PriceException(){
		super("The price is not valid, it might be negative or there might be a typo");
}
}


