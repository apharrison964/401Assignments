package lec14.ex4;

import java.util.Observer;
import java.util.Observable;

public class DukeFan implements Observer {

	public void update(Observable o, Object arg) {
		Game game = (Game) o;     // You have to cast because the built in observer only takes in Observable, Object
								  // This is contravarient casting, then you can get to the specific subclass methods
		String who_scored = (String) arg;
		
		if (who_scored.equals("Duke")) {
			if (game.whoIsWinning().equals("Duke")) {
				System.out.println("Go Devils!");
			} else {
				System.out.println("Getting there, Duke!");
			}
		} 
	}
}
