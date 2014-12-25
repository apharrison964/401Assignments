package a7adept;

import java.util.Observable;
import java.util.Observer;

import a7adept.PlateEvent.EventType;

public class PlateCounter implements Observer {

	private int redCount = 0;
	private int greenCount = 0;
	private int blueCount = 0; 
	private int goldCount = 0;


	public int getRedPlateCount(){
		return redCount;
	}

	public int getGreenPlateCount(){
		return greenCount;
	}

	public int getBluePlateCount(){
		return blueCount;
	}

	public int getGoldPlateCount(){
		return goldCount;
	}

	@Override
	public void update(Observable belt, Object arg) {
		PlateEvent plate = (PlateEvent) arg;

		if(plate.getPlate() != null){
			if(plate.getType() == EventType.PLATE_REMOVED){
				switch(plate.getPlate().getColor()){
				case RED: {
					redCount--;
					break;
				}
				case BLUE: {
					blueCount--;
					break;
				}
				case GREEN: {
					greenCount--;
					break;
				}
				case GOLD: {
					goldCount--;
					break;
				}
				}
			}
			else if(plate.getType() == EventType.PLATE_PLACED){
				switch(plate.getPlate().getColor()){
				case RED: {
					redCount++;
					break;
				}
				case BLUE: {
					blueCount++;
					break;
				}
				case GREEN:{
					greenCount++;
					break;
				}
				case GOLD: {
					goldCount++;
					break;
				}
				}

			}
		}
	}
}
