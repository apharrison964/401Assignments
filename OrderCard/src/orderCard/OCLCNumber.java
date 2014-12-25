package orderCard;

public class OCLCNumber {

	private static int numOCLC;

	public OCLCNumber (int numOCLC) {
		OCLCNumber.numOCLC = numOCLC;
	}

	@SuppressWarnings("unused")
	public static int getOCLC(int oclc) throws OCLCPriceException {
		boolean isInt;
		if(isInt = false){
			throw new OCLCPriceException();
		}else{
			return numOCLC;
		}
	}



}


