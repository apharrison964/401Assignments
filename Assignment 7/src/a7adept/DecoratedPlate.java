package a7adept;

import comp401.sushi.Plate;

public interface DecoratedPlate extends Plate {
	int rotationCount();
	Plate getWrappedPlate();
	int getAge(int passedCount);
}