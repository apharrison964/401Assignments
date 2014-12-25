package a5tester;

public class Asserts {

	public static Object[] equals(Object actual, Object expected, String id){
		boolean cond;
		if (actual==null || expected==null)
			cond=(actual==null && expected==null);
		else
			cond = (actual==expected || actual.equals(expected));
		Object[] result={
				cond,
				new String()
		};
		if (cond)
			result[1]=String.format("value for %s correct", id);
		else
			result[1]=String.format("value for %s incorrect, expected %s, got %s", id, expected, actual);
		
		return result;
	}
	
	public static Object[] type(Object object, Class<?> type, String id){
		boolean cond = type.isInstance(object);
		Object[] result={
				cond,
				new String()
		};
		if (cond)
			result[1]=String.format("type for %s correct", id);
		else
			result[1]=String.format("type for %s incorrect, expected %s, got %s", id, type, object.getClass());
		
		return result;
	}
	
}
