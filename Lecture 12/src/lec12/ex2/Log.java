package lec12.ex2;

import java.util.List;
import java.util.ArrayList;

public abstract class Log {
	
	abstract public void addEntry(String entry);
	
	abstract public void printLog();
	
	private static Log theLog;
	
	public static Log getLog() {
		if (theLog == null) {
			// There currently is no log, so create one.
//			theLog = new MemoryLog();
//			theLog = new ConsoleLog();
			theLog = new NullLog();
		}
		return theLog;
	}	
}

class MemoryLog extends Log {
	
	private List<String> entries;

	protected MemoryLog() {
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
}

class ConsoleLog extends Log {
	
	public void addEntry(String entry) {
		System.out.println(entry);
	}
	
	public void printLog() {
	}
}

class NullLog extends Log {

	public void addEntry(String entry) {
	}

	public void printLog() {
	}
}