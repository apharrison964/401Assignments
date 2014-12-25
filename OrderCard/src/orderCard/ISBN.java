package orderCard;

public class ISBN {

	private static double numISBN;
	private static double[] numISBNArr;

	public ISBN (double numISBN) {
		ISBN.numISBN = numISBN;
		numISBN = numISBNArr[(int) numISBN];
	}

	public static double getISBN(double num) throws ISBNNumberLessException, ISBNNumberGreaterException, ISBNNumberNotValidException {
		if(numISBNArr.length <= 13){
			throw new ISBNNumberLessException();
		}else if(numISBNArr.length > 13){
			throw new ISBNNumberGreaterException();
		}else if(numISBNArr.length != 13){
			throw new ISBNNumberNotValidException();
		}else{
			return numISBN;
		}
	}


}


