package lec12.ex5;

public abstract class Service {

//Don't need a protected constructor because there can be only one public class in one file,
	//and since the one above is abstract, you don't need a private or protected class to protect the code from being made
	abstract public void doService();
	
	static boolean online;
	
	static public void goOnline() {
		online = true;
	}
	
	static public void goOffline() {
		online = false;
	}
	
	static public Service getService() {
		if (online) {
			return new OnlineService();
		}
		else {
			return new OfflineService();
		}
	}
}
//Actual factory method since it returns the instance of service
//No public consructor
class OnlineService extends Service {

	public void doService() {
		System.out.println("Doing service on-line");
	}
}

class OfflineService extends Service {

	public void doService() {
		System.out.println("Doing service off-line");
	}
}