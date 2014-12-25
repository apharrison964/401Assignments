package lec10.ex2;

public interface Engine {

	static final int MAX_THROTTLE = 10;
	
	enum Gear {PARK, DRIVE, OVERDRIVE, FIRST, SECOND, THIRD, FOURTH, FIFTH};
	
	Gear getGear();
	void setGear(Gear new_gear);
	int getThrottle();
	void setThrottle(int throttle);

}
