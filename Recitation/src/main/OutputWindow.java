package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** View for the output of the program. 
 *  Created during runtime as the output is produced. */
public class OutputWindow extends JFrame {
	
	// Sets up window, still need to make visible
	public OutputWindow(String text) {
		this.setTitle("Output Window");
		
		JPanel panel = new JPanel();
		this.add(panel);
		addComponents(panel, text);
		
		this.pack();		
	}
	
	// Helper method for the constructor
	private void addComponents(JPanel panel, String text) {
		// TODO add a "Cipher Text:" label to 'panel'
		
		// TODO add a component to display 'text'
	}
}
