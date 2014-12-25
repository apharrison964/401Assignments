package lec12.ex1;
//SINGLETON
import java.util.List;
import java.util.ArrayList;

public class Log {

	private List<String> entries;
	
	private Log() {
		entries = new ArrayList<String>();
	}

	public void addEntry(String entry) {
		entries.add(entry);
	}

	public void printLog() {
		System.out.println("Log Entries:");
		for(String entry : entries) {
			System.out.println("* " + entry);
		}
	}
	
	private static Log theLog; //The private static field that holds the one permanent thing
	
	public static Log getLog() {
		if (theLog == null) {
			// There currently is no log, so create one.
			theLog = new Log();
		}
		return theLog;
	}	
}
//Class employing the singleton pattern