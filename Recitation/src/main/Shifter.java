package main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** The "model" component of the program
 *  Computes a Caesar cipher using the information
 *  entered in the input window.
 */
public class Shifter implements ActionListener {
	
	public static final int SHIFT_AMOUNT = 5;
	
	private InputWindow view;
	
	public Shifter(InputWindow view) {
		this.view = view;
		view.registerModel(this);
	}
	
	public String caesarShift(String plainText) {
		String cipherText = "";
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			char d = (char) (c + SHIFT_AMOUNT);
			cipherText += d;
		}
		return cipherText;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO get the input and encode it
		String shifted = caesarShift(view.toString());
		
		// TODO create a new window and display output
		OutputWindow win = new OutputWindow(shifted);
	}
}
