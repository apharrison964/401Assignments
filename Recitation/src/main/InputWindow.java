package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InputWindow extends JFrame {
	
	private JTextField text;
	private JButton enter;

	// Sets up window, still need to make visible
	public InputWindow() {
		this.setTitle("Input Window");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		this.add(panel);
		addComponents(panel);

		this.pack();
	}
	
	// Helper method for the constructor
	private void addComponents(JPanel panel) {
		// TODO add "Plain Text:" label to 'panel'
		panel.add("Plain Text", panel);
		
		// TODO set instance var 'text' and add text field to 'panel'
		panel.add(text, panel);
		
		// TODO set instance var 'enter' and add button to 'panel'
		panel.add(enter, panel);
		
		// TODO key listener for Enter button
		panel.addKeyListener(null);
	}
	
	public void registerModel(Shifter model) {
		// TODO model listens to 'Enter' button
	}
	
	public String getInput() {
		return text.toString();
		// TODO return the contents of the text box
	}
}
