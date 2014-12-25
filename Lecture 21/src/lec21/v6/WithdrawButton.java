package lec21.v6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class WithdrawButton extends JButton implements ActionListener, Runnable {

	private Account account;
	private int amount;
	
	public WithdrawButton(Account account, int amount) {
		super("Withdraw " + amount);
		this.account = account;
		this.amount = amount;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		(new Thread(this)).start();
	}
	
	public void run() {
		account.withdraw(amount);
	}
}
