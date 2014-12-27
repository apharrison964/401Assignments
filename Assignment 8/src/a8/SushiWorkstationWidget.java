package a8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.*;

import comp401.sushi.*;

@SuppressWarnings("serial")
public class SushiWorkstationWidget extends JPanel implements ActionListener  {

	private Avocado avocado;
	private Crab crab;
	private Eel eel;
	private Rice rice;
	private Salmon salmon;
	private Seaweed seaweed;
	private Shrimp shrimp;
	private Tuna tuna;
	private Roll roll;
	private Sashimi sashimi;
	private Nigiri nigiri;
	private JPanel topLevel, gridLay, sushiButtons, sash, nigi;
	private JSlider goldAmount, avocadoSlider, crabSlider, eelSlider, 
	riceSlider, salmonSlider, seaweedSlider, shrimpSlider, tunaSlider;
	private JButton makeRoll, sashimiButton, nigiriButton;
	private String[] type = {"Crab", "Eel", "Salmon", "Shrimp", "Tuna"};
	private String[] choosePlate = {"Red Plate", "Blue Plate", "Green Plate", "Gold Plate"};
	private JComboBox<String> coloredPlates, sashimiType, nigiriType;
	private ArrayList<Ingredient> ingreList;

	/* Do not change the following line. */
	private List<WorkstationListener> listeners;

	public SushiWorkstationWidget() {
		/* Do not change the following line*/
		listeners = new ArrayList<WorkstationListener>();

		/* Replace the following line with your own code. */
		/*
		 * If the amount of the contents on the plate exceeds the price of the 
		 * plate, an exception is thrown. I used a try catch block and printed
		 * the exception in the catch statement
		 */
		topLevel = new JPanel();
		topLevel.setLayout(new BorderLayout());
		add(topLevel);

		gridLay = new JPanel();
		gridLay.setLayout(new GridLayout(0, 2));

		gridLay.add(new JLabel("Plate Color: "));
		coloredPlates = new JComboBox<String>(choosePlate);
		coloredPlates.setVisible(true);
		gridLay.add(coloredPlates);

		gridLay.add(new JLabel("Gold Price: "));
		goldAmount = new JSlider(500, 1500);
		goldAmount.setMajorTickSpacing(100);
		Hashtable<Integer, JLabel> priceLabel = new Hashtable<Integer, JLabel>();
		priceLabel.put(new Integer(500), new JLabel("5.00"));
		priceLabel.put(new Integer(1500), new JLabel("15.00"));
		goldAmount.setPaintTicks(true);
		goldAmount.setPaintLabels(true);
		goldAmount.setLabelTable(priceLabel);
		gridLay.add(goldAmount);

		gridLay.add(new JLabel("Avocado: "));
		avocadoSlider = new JSlider(0, 100);
		gridLay.add(avocadoSlider);

		gridLay.add(new JLabel("Crab: "));
		crabSlider = new JSlider(0, 100);
		gridLay.add(crabSlider);

		gridLay.add(new JLabel("Eel: "));
		eelSlider = new JSlider(0, 100);
		gridLay.add(eelSlider);

		gridLay.add(new JLabel("Rice: "));
		riceSlider = new JSlider(0, 100);
		gridLay.add(riceSlider);

		gridLay.add(new JLabel("Salmon: "));
		salmonSlider = new JSlider(0, 100);
		gridLay.add(salmonSlider);

		gridLay.add(new JLabel("Seaweed: "));
		seaweedSlider = new JSlider(0, 100);
		gridLay.add(seaweedSlider);

		gridLay.add(new JLabel("Shrimp: "));
		shrimpSlider = new JSlider(0, 100);
		gridLay.add(shrimpSlider);

		gridLay.add(new JLabel("Tuna: "));
		tunaSlider = new JSlider(0, 100);
		gridLay.add(tunaSlider);

		topLevel.add(gridLay, BorderLayout.NORTH);

		makeRoll = new JButton("Make Roll");
		makeRoll.setActionCommand("Make Roll");
		topLevel.add(makeRoll);

		sushiButtons = new JPanel();
		sushiButtons.setLayout(new BorderLayout());
		topLevel.add(sushiButtons, BorderLayout.SOUTH);

		sash = new JPanel();
		sash.setLayout(new BorderLayout());
		sash.add(new JLabel("Sashimi Type: "), BorderLayout.WEST);
		sushiButtons.add(sash, BorderLayout.NORTH);

		sashimiType = new JComboBox<String>(type);
		sash.add(sashimiType, BorderLayout.CENTER);
		sashimiButton = new JButton("Make Sashimi");
		sash.add(sashimiButton, BorderLayout.EAST);

		nigi = new JPanel();
		nigi.setLayout(new BorderLayout());
		nigi.add(new JLabel("Nigiri Type: "), BorderLayout.WEST);
		sushiButtons.add(nigi, BorderLayout.SOUTH);

		nigiriType = new JComboBox<String>(type);
		nigi.add(nigiriType, BorderLayout.CENTER);
		nigiriButton = new JButton("Make Nigiri");
		nigi.add(nigiriButton, BorderLayout.EAST);

		makeRoll.addActionListener(this);
		nigiriButton.addActionListener(this);
		sashimiButton.addActionListener(this);
		coloredPlates.addActionListener(this);

	}

	/* Do not change the following three methods:
	 * addWorkstationListener
	 * removeWorkstationListener
	 * publicPlateToListeners
	 */

	public void addWorkstationListener(WorkstationListener l) {
		listeners.add(l);
	}

	public void removeWorkstationListener(WorkstationListener l) {
		listeners.remove(l);
	}

	private void publishPlateToListeners(Plate p) {
		for (WorkstationListener l : listeners) {
			l.handleMadePlate(p);
		}
	}

	public JSlider getSliderValue(JSlider slider){
		System.out.println((double) slider.getValue() / 100);
		if((double) slider.getValue() / 100.0 != 0){
			if(slider == avocadoSlider){
				avocado = new Avocado((double) avocadoSlider.getValue() / 100.0);	
				ingreList.add(avocado);
			}
			if(slider == crabSlider){
				crab = new Crab((double) crabSlider.getValue() / 100.0);
				ingreList.add(crab);
			}
			if(slider == eelSlider){
				eel = new Eel((double) eelSlider.getValue() / 100.0);
				ingreList.add(eel);
			}
			if(slider == riceSlider){
				rice = new Rice((double) riceSlider.getValue() / 100.0);
				ingreList.add(rice);
			}
			if(slider == salmonSlider){
				salmon = new Salmon((double) salmonSlider.getValue() / 100.0);
				ingreList.add(salmon);
			}
			if(slider == seaweedSlider){
				seaweed = new Seaweed((double) seaweedSlider.getValue() / 100.0);
				ingreList.add(seaweed);
			}
			if(slider == shrimpSlider){
				shrimp = new Shrimp((double) shrimpSlider.getValue() / 100.0);
				ingreList.add(shrimp);
			}
			if(slider == tunaSlider){
				tuna = new Tuna((double) tunaSlider.getValue() / 100.0);
				ingreList.add(tuna);
			}

		}
		return slider;
	}
	// Getting the color of the plate from the box and then adding the roll for
	// each colored plate. This method is only used with the makeRoll button
	public JComboBox<String> getPlateComboBox(JComboBox<String> box){
		if(box.getSelectedItem().toString().equals("Red Plate")){
			try {
				Plate plate = new RedPlate(roll);
				publishPlateToListeners(plate);
			} catch (PlatePriceException e1) {
				System.out.println(e1);
			}
		}
		if(box.getSelectedItem().toString().equals("Green Plate")){
			try {
				Plate plate = new GreenPlate(roll);
				publishPlateToListeners(plate);
			} catch (PlatePriceException e1) {
				System.out.println(e1);
			}
		}
		if(box.getSelectedItem().toString().equals("Blue Plate")){
			try {
				Plate plate = new BluePlate(roll);
				publishPlateToListeners(plate);
			} catch (PlatePriceException e1) {
				System.out.println(e1);
			}
		}
		if(box.getSelectedItem().toString().equals("Gold Plate")){
			try {
				Plate plate = new GoldPlate(roll, (double) goldAmount.getValue() / 100.0);
				publishPlateToListeners(plate);
			} catch (PlatePriceException e1) {
				System.out.println(e1);
			}
		}
		return box;
	}

	public Sashimi getSashimi(JComboBox<String> s, ActionEvent e){
		if(e.getSource() == sashimiButton){
			if(s.getSelectedItem().toString().equals("Crab")){
				sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
			}
			if(s.getSelectedItem().toString().equals("Eel")){
				sashimi = new Sashimi(Sashimi.SashimiType.EEL);
			}
			if(s.getSelectedItem().toString().equals("Salmon")){
				sashimi = new Sashimi(Sashimi.SashimiType.SALMON);
			}
			if(s.getSelectedItem().toString().equals("Shrimp")){
				sashimi = new Sashimi(Sashimi.SashimiType.SHRIMP);
			}
			if(s.getSelectedItem().toString().equals("Tuna")){
				sashimi = new Sashimi(Sashimi.SashimiType.TUNA);
			}
		}
		return sashimi;
	}

	public Nigiri getNigiri(JComboBox<String> s, ActionEvent e){
		if(e.getSource() == nigiriButton){
			if(s.getSelectedItem().toString().equals("Crab")){
				nigiri = new Nigiri(Nigiri.NigiriType.CRAB);
			}
			if(s.getSelectedItem().toString().equals("Eel")){
				nigiri = new Nigiri(Nigiri.NigiriType.EEL);
			}
			if(s.getSelectedItem().toString().equals("Salmon")){
				nigiri = new Nigiri(Nigiri.NigiriType.SALMON);
			}
			if(s.getSelectedItem().toString().equals("Shrimp")){
				nigiri = new Nigiri(Nigiri.NigiriType.SHRIMP);
			}
			if(s.getSelectedItem().toString().equals("Tuna")){
				nigiri = new Nigiri(Nigiri.NigiriType.TUNA);
			}
		}
		return nigiri;
	}
	// Determining if the button pressed was sashimi or nigiri, and then determining
	// the plate color and adding the respective sushi to the plate. This method
	// only works with sashimiButton and nigiriButton
	public JComboBox<String> getSushiTypeButton(JComboBox<String> s, ActionEvent e) {
		if(e.getSource() == sashimiButton){
			if(coloredPlates.getSelectedItem().toString().equals("Red Plate")){
				sashimi = getSashimi(s, e);
				try {
					Plate plate = new RedPlate(sashimi);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Green Plate")){
				sashimi = getSashimi(s, e);
				try {
					Plate plate = new GreenPlate(sashimi);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Blue Plate")){
				sashimi = getSashimi(s, e);
				try {
					Plate plate = new BluePlate(sashimi);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Gold Plate")){
				sashimi = getSashimi(s, e);
				try {
					Plate plate = new GoldPlate(sashimi, (double) goldAmount.getValue() / 100.0);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
		}
		if(e.getSource() == nigiriButton){
			if(coloredPlates.getSelectedItem().toString().equals("Red Plate")){
				nigiri = getNigiri(s, e);
				try {
					Plate plate = new RedPlate(nigiri);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Green Plate")){
				nigiri = getNigiri(s, e);
				try {
					Plate plate = new GreenPlate(nigiri);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Blue Plate")){
				nigiri = getNigiri(s, e);
				try {
					Plate plate = new BluePlate(nigiri);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
			if(coloredPlates.getSelectedItem().toString().equals("Gold Plate")){
				nigiri = getNigiri(s, e);
				try {
					Plate plate = new GoldPlate(nigiri, (double) goldAmount.getValue() / 100.0);
					publishPlateToListeners(plate);
				} catch (PlatePriceException e1) {
					System.out.println(e1);
				}
			}
		}
		return s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ingreList = new ArrayList<Ingredient>();
		avocadoSlider = getSliderValue(avocadoSlider);
		crabSlider = getSliderValue(crabSlider);
		eelSlider = getSliderValue(eelSlider);
		riceSlider = getSliderValue(riceSlider);
		salmonSlider = getSliderValue(salmonSlider);
		seaweedSlider = getSliderValue(seaweedSlider);
		shrimpSlider = getSliderValue(shrimpSlider);
		tunaSlider = getSliderValue(tunaSlider);

		Ingredient[] ingredient = new Ingredient[ingreList.size()];
		ingredient = ingreList.toArray(ingredient);	
		roll = new Roll(ingredient);

		if(e.getSource() == makeRoll){
			if(ingredient.length > 0){
				coloredPlates = getPlateComboBox(coloredPlates);
			} else {
				System.out.println("There is nothing on the roll!");
			}
		}
		if(e.getSource() == sashimiButton){
			if(ingredient.length > 0){
				sashimiType = getSushiTypeButton(sashimiType, e);
			} else {
				System.out.println("There is nothing on the roll!");
			}
		}
		if(e.getSource() == nigiriButton){
			if(ingredient.length > 0){
				nigiriType = getSushiTypeButton(nigiriType, e);
			} else {
				System.out.println("There is nothing on the roll!");
			}
		}
	}
}
