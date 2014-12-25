package lec16.ex1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Hello, World");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel main_panel = new JPanel();
		main_frame.setContentPane(main_panel);
		
		main_panel.setLayout(new BorderLayout());
		
		JLabel hello_world_label = new JLabel("Hello, World!");
		hello_world_label.setHorizontalAlignment(SwingConstants.CENTER);
		hello_world_label.setForeground(Color.BLUE);
		hello_world_label.setOpaque(true);
		hello_world_label.setBackground(Color.YELLOW);

		main_panel.add(hello_world_label, BorderLayout.CENTER);
		
		main_frame.setVisible(true);
		
	}
}
