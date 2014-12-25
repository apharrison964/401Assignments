package lec10.ex3;

public class AutomaticEngine extends EngineImpl {


	@Override
	public void setGear(Gear new_gear) {
		switch(new_gear) {
		case PARK:
			if (getThrottle() != 0) {
				throw new RuntimeException("Attempted to park while throttle not at zero");
			}
		case DRIVE:
		case OVERDRIVE:
			super.setGear(new_gear);
			break;
		default:
			throw new RuntimeException("Invalid Gear");
		}
	}
}
