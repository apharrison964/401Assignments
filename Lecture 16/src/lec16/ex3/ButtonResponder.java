package lec16.ex3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonResponder implements ActionListener {

	private JLabel target;

	public ButtonResponder(JLabel target_label) {
		target = target_label;
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("hello")) {
			target.setText("Hello!");
		} else if (command.equals("bye")) {
			target.setText("Bye!");
		} else if (command.equals("yes")) {
			target.setText("Yes!");
		}

	}
}
