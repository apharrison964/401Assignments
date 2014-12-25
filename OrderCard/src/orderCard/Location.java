package orderCard;

public class Location {

	private static String location;

	public Location (String location) {
		Location.location = location;
	}

	public static String getLocation(String location) {
		Location.location = location;
		return Location.location;
	}


}
