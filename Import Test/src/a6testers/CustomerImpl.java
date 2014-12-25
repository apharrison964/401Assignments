package a6testers;

import comp401.sushi.Plate;

import java.util.NoSuchElementException;
import a6jedi.Belt;
import a6jedi.BeltFullException;
import a6jedi.BeltPlateException;
import a6jedi.Customer;

public class CustomerImpl implements Customer { 
    public void observePlateOnBelt (Belt b, Plate p, int position) {
        Plate.Color color = p.getColor();
		System.out.println("Update: there is now a " + color + " colored plate at position: " + position);
	}
}
