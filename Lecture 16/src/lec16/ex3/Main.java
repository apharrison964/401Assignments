package lec16.ex3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {
	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Button Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.setSize(300, 100);
		
		JPanel main_panel = new JPanel();
		main_frame.setContentPane(main_panel);
		
		main_panel.setLayout(new BorderLayout());
		
		JLabel my_label = new JLabel("");
		my_label.setHorizontalAlignment(SwingConstants.CENTER);
		my_label.setForeground(Color.BLUE);
		my_label.setOpaque(true);
		my_label.setBackground(Color.YELLOW);

		main_panel.add(my_label, BorderLayout.CENTER);

		JPanel button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(1,3));
		
		ButtonResponder responder = new ButtonResponder(my_label);
		
		JButton b1 = new JButton("Say Hello");
		b1.setActionCommand("hello");
		b1.addActionListener(responder);
		button_panel.add(b1);
		
		JButton b2 = new JButton("Say Bye");
		b2.setActionCommand("bye");
		b2.addActionListener(responder);
		button_panel.add(b2);
		
		JButton b3 = new JButton("Say Yes");
		b3.setActionCommand("yes");
		b3.addActionListener(responder);
		button_panel.add(b3);

		main_panel.add(button_panel, BorderLayout.SOUTH);
	
		main_frame.setVisible(true);
	}
}
