package lec21.v8;

public class Main {

	public static void main(String[] args) {

		SynchPoint synch_point = new SynchPoint(3);
		
		CountThenWaitThread ct_a = new CountThenWaitThread("A", 5, synch_point);
		CountThenWaitThread ct_b = new CountThenWaitThread("B", 6, synch_point);
		CountThenWaitThread ct_c = new CountThenWaitThread("C", 7, synch_point);

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
	}
}

class CountThenWaitThread extends Thread {

	private String prefix;
	private int count;
	private SynchPoint synch_point;

	public CountThenWaitThread(String prefix, int count, SynchPoint synch_point) {
		this.prefix = prefix;
		this.count = count;
		this.synch_point = synch_point;
	}

	public void run() {
		while (true) {
			for (int i=0; i<count; i++) {
				System.out.println(prefix + ": " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}

			synch_point.check_in(prefix);
		}
	}
}

class SynchPoint {
	private int num_expected;
	private int num_checked_in;

	public SynchPoint(int num_expected) {
		this.num_expected = num_expected;
		this.num_checked_in = 0;
	}

	synchronized void check_in(String prefix) {
		try {
			System.out.println(prefix + " checking in");
			num_checked_in++;

			if (num_checked_in < num_expected) {
				System.out.println(num_checked_in + " checked in, waiting...");
				wait();
			} else {
				System.out.println("All " + num_expected + " present and accounted for. Notifying those waiting");
				num_checked_in = 0;
				notifyAll();
			}
			System.out.println(prefix + " continuing on.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}