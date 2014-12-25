package lec21.v2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LongRunner extends Thread implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		this.start();
	}
	
	public void run() {
		System.out.println("Printing 0 to 2 million");
		for (int i=0; i<1000000; i++) {
			System.out.println(Integer.toString(i));
		}
		System.out.println("Done");		
	}
}
