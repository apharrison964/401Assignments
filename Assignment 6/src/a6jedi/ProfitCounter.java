package a6jedi;

import java.util.Observable;
import java.util.Observer;
import a6jedi.PlateEvent.EventType;

public class ProfitCounter implements Observer {

	private double total = 0;
	private int count = 0;

	public double getTotalBeltProfit(){
		return total;
	}

	public double getAverageBeltProfit(){
		if(total == 0 || count == 0){
			return 0;
		}
		return total / count;
	}

	@Override
	public void update(Observable belt, Object arg) {
		PlateEvent plate = (PlateEvent) arg;

		if(plate.getPlate() != null){
			if(plate.getType() == EventType.PLATE_REMOVED){
				total -= plate.getPlate().getProfit();
				count--;
			} else if(plate.getType() == EventType.PLATE_PLACED){
				total += plate.getPlate().getProfit();
				count++;
			}
		}
	}

}
