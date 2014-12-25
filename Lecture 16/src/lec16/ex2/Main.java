package lec16.ex2;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		int choice = JOptionPane.showConfirmDialog(null, "Is it safe?");
		System.out.println("You chose: " + choice);
		
		String input = JOptionPane.showInputDialog("What say you?");
		
		JOptionPane.showMessageDialog(null, "You said: " + input);
		System.out.println("Done");
	}
}
