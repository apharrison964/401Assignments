package a7jedi;

import java.util.Observable;
import java.util.Observer;

import comp401.sushi.Ingredient;
import comp401.sushi.Sushi;
import a7jedi.PlateEvent;
import a7jedi.PlateEvent.EventType;

public class SpoilageCollector implements Observer {

	private Belt belt;
	private double cost = 0;
	private double spoiledShell = 0;
	private double spoiledSea = 0;
	private double totalSpoiled = 0;

	public double getTotalSpoiledCost(){
		return cost;
	}

	public double getTotalSpoiledShellfish(){
		return spoiledShell;
	}

	public double getTotalSpoiledSeafood(){
		return spoiledSea;
	}

	public double getTotalSpoiledFood(){
		return totalSpoiled;
	}

	@Override
	public void update(Observable observe, Object object) {
		PlateEvent event = (PlateEvent) object;
		belt = (Belt) observe;

		if(event.getType() == EventType.PLATE_SPOILED){

			Sushi s = event.getPlate().getContents();
			belt.removePlateAtPosition(event.getPosition());
			cost += s.getCost();

			for(Ingredient i: s.getIngredients()){

				if(i.isShellfish()){
					spoiledShell += i.getAmount();
				} 

				if(!i.isVegetarian()){
					spoiledSea += i.getAmount();
				}

				totalSpoiled += i.getAmount();
			}
		}
	}
}




