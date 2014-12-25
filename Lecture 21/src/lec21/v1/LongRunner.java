package lec21.v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LongRunner implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Printing 0 to 2 million");
		for (int i=0; i<1000000; i++) {
			System.out.println(Integer.toString(i));
		}
		System.out.println("Done");
	}
}
