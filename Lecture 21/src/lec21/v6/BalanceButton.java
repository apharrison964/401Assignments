package lec21.v6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BalanceButton extends JButton implements ActionListener {

	private Account account;
	
	public BalanceButton(String text, Account account) {
		super(text);
		this.account = account;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Current " + getText() + " is: " + account.getBalance());
	}
	
}
