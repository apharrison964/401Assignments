package lec21.v4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BalanceButton extends JButton implements ActionListener {

	private Account account;
	
	public BalanceButton(Account account) {
		super("Balance");
		this.account = account;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Current balance is: " + account.getBalance());
	}
	
}
