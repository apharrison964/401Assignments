package lec21.v4;

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

		
		Account account = new Account(100);
		
		WithdrawButton take5 = new WithdrawButton(account, 5);
		DepositButton give5 = new DepositButton(account, 5);
		BalanceButton balance = new BalanceButton(account);
		
		main_panel.add(take5);
		main_panel.add(give5);
		main_panel.add(balance);
		
		main_frame.pack();
		main_frame.setVisible(true);
	}
}
