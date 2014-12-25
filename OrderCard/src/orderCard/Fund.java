package orderCard;

public class Fund {

	private static String fundName;

	public Fund (String fundName) {
		Fund.fundName = fundName;
	}

	public static String getFundName(String name) {
		return fundName;
	}


}
