package orderCard;

public class Imprint {

	private static String publisherName;

	public Imprint (String publisherName) {
		Imprint.publisherName = publisherName;
	}

	public static String getImprint(String publisher) {
		return publisherName;
	}


}
