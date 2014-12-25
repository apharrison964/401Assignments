package orderCard;

public class Title {

	private static String title;

	public Title (String title) {
		Title.title = title;
	}

	public static String getTitle(String title) {
		Title.title = title;
		return Title.title;
	}


}
