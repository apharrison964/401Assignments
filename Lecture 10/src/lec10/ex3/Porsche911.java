package lec10.ex3;

import lec10.ex3.Engine.Gear;

public class Porsche911 implements Car, AdjustableHorn {

	private ManualEngine engine;
	private FancyHorn horn;

	public Porsche911() {
		engine = new ManualEngine();
		horn = new FancyHorn();
	}
	
	@Override
	public void go() {
		if (engine.getGear() == Gear.PARK) {
			engine.setGear(Gear.FIRST);
			engine.setThrottle(1);
		}
	}

	@Override
	public void stop() {
		if (engine.getGear() != Gear.PARK) {
			engine.setThrottle(0);
			engine.setGear(Gear.PARK);
		}
	}

	@Override
	public void speedUp() {
		if (engine.getGear() == Gear.PARK) { 
			return;
		}
		if (engine.getThrottle() < EngineImpl.MAX_THROTTLE) {
			engine.setThrottle(engine.getThrottle() + 1);
		} else if (engine.getGear() != Gear.FIFTH) {
			engine.setThrottle(engine.getThrottle() / 2);
			if (engine.getGear() == Gear.FIRST) {
				engine.setGear(Gear.SECOND);
			} else if (engine.getGear() == Gear.SECOND) {
				engine.setGear(Gear.THIRD);
			} else if (engine.getGear() == Gear.THIRD) {
				engine.setGear(Gear.FOURTH); 
			} else {
				engine.setGear(Gear.FIFTH);
			}
		}
	}

	@Override
	public void slowDown() {
		if (engine.getGear() == Gear.PARK) {
			return;
		}

		if ((engine.getThrottle() <= 5) &&
			(engine.getGear() != Gear.FIRST)) {
			engine.setThrottle(7);
			if (engine.getGear() == Gear.FIFTH) {
				engine.setGear(Gear.FOURTH);
			} else if (engine.getGear() == Gear.FOURTH) {
				engine.setGear(Gear.THIRD);
			} else if (engine.getGear() == Gear.THIRD){
				engine.setGear(Gear.SECOND);
			} else {
				engine.setGear(Gear.FIRST);
			}
		} else {
			if (engine.getThrottle() > 1) {
				engine.setThrottle(engine.getThrottle()-1);
			} else {
				throw new RuntimeException("You stalled the car");
			}
		}
	}
	
	@Override
	public void honk() {
		horn.honk();
	}
	
	public int getHornVolume() {
		return horn.getHornVolume();
	}

	public void setHornVolume(int v) {
		horn.setHornVolume(v);
	}
}
