package lec21.v6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TransferButton extends JButton implements ActionListener, Runnable {

	private Account from;
	private Account to;
	
	public TransferButton(String text, Account from, Account to) {
		super(text);
		this.from = from;
		this.to = to;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		(new Thread(this)).start();
	}
	
	public void run() {
		from.transfer(5, to);
	}
	
}
