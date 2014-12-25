package lec21.v3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Thread example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel main_panel = new JPanel();
		main_frame.setContentPane(main_panel);

		LongRunner lr1 = new LongRunner();
		LongRunner lr2 = new LongRunner();
		
		JButton b1 = new JButton("Button 1");
		b1.addActionListener(lr1);
		
		JButton b2 = new JButton("Button 2");
		b2.addActionListener(lr2);
		
		JSlider s = new JSlider(0, 100);
		main_panel.add(b1);
		main_panel.add(b2);
		main_panel.add(s);
		
		main_frame.pack();
		main_frame.setVisible(true);
	}
}
