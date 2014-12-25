package orderCard;

public class ApprovedBy {

	private static String name;

	public ApprovedBy (String name) {
		ApprovedBy.name = name;
	}

	public static String getApprovedBy(String name) {
		ApprovedBy.name = name;
		return ApprovedBy.name;
	}


}
