package lec21.v6;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Main {

	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Consistency Example");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel main_panel = new JPanel();
		main_frame.setContentPane(main_panel);

		
		Account a = new Account(100);
		Account b = new Account(200);
		
		TransferButton a2b = new TransferButton("$5 A->B", a, b);
		TransferButton b2a = new TransferButton("$5 B->A", b, a);
		BalanceButton a_balance = new BalanceButton("A Balance", a);
		BalanceButton b_balance = new BalanceButton("B Balance", b);

		main_panel.add(a2b);
		main_panel.add(b2a);
		main_panel.add(a_balance);
		main_panel.add(b_balance);
		
		main_frame.pack();
		main_frame.setVisible(true);
	}
}
