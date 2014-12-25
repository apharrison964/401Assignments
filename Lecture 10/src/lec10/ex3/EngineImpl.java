package lec10.ex3;

abstract public class EngineImpl implements Engine {
	
	private int throttle;
	private Gear gear;

	EngineImpl() {
		throttle = 0;
		gear = Gear.PARK;
	}
	
	@Override
	public Gear getGear() {
		return gear;
	}

	@Override
	public void setGear(Gear new_gear) {
		gear = new_gear;
	}

	@Override
	public int getThrottle() {
		return throttle;
	}

	@Override
	public void setThrottle(int throttle) {
		if ((throttle < 0) || (throttle > MAX_THROTTLE)) {
			throw new RuntimeException("Illegal throttle setting");
		}
		this.throttle = throttle;
	}

}
