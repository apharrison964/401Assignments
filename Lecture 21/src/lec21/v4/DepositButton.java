package lec21.v4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class DepositButton extends JButton implements ActionListener, Runnable {

	private Account account;
	private int amount;
	
	public DepositButton(Account account, int amount) {
		super("Deposit " + amount);
		this.account = account;
		this.amount = amount;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		(new Thread(this)).start();
	}
	
	public void run() {
		account.deposit(amount);
	}
	
}
