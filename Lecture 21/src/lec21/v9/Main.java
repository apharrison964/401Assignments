package lec21.v9;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		for(int i=0; i<10; i++) {
			long start = System.nanoTime();
			Thread.sleep(1000);
			long end = System.nanoTime();
			System.out.println("Expected to sleep for 1000 ms");
			System.out.println("Actually slept for " + (((double) (end - start)) / 1000000.0) + " ms");
		}
		
	}

}
