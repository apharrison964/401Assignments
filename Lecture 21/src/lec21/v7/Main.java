package lec21.v7;

public class Main {

	public static void main(String[] args) {

		CountingThread ct_a = new CountingThread("A", 5);
		CountingThread ct_b = new CountingThread("B", 7);
		CountingThread ct_c = new CountingThread("C", 10);

		ct_a.start();
		ct_b.start();
		ct_c.start();

		try {
			ct_a.join();
			System.out.println("Joined back with A");

			ct_b.join();
			System.out.println("Joined back with B");

			ct_c.join();
			System.out.println("Joined back with C");		


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main thread done");
	}
}

class CountingThread extends Thread {

	private String prefix;
	private int count;

	public CountingThread(String prefix, int count) {
		this.prefix = prefix;
		this.count = count;
	}

	public void run() {
		for (int i=0; i<count; i++) {
			System.out.println(prefix + ": " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
