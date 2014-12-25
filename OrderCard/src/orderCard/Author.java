package orderCard;

public class Author {

	private static String first;
	private static String last;

	public Author (String first, String last) {
		Author.first = first;
		Author.last = last;
	}

	public static String getFullName(String fullName) {
		return first + " " + last;
	}

}

