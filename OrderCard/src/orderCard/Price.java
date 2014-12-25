package orderCard;

public class Price {

	private static double price;

	public Price (double price) {
		Price.price = price;
	}

	public static double getPrice(double price) throws PriceException {
		Price.price = price;
		if(Price.price < 0){
			throw new PriceException();

		}else{
			return Price.price;
		}

	}
}


