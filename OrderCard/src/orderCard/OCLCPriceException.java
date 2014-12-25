package orderCard;

@SuppressWarnings("serial")
public class OCLCPriceException extends Exception{
	public OCLCPriceException(){
		super("OCLC number is not valid, might be negative or a typo");
	}
}
