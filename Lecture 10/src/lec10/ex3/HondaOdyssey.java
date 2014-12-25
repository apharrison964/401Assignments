package lec10.ex3;

import lec10.ex3.Engine.Gear;

public class HondaOdyssey implements Car, Horn {

	private AutomaticEngine engine;
	private BasicHorn horn;
	
	public HondaOdyssey() {
		engine = new AutomaticEngine();
		horn = new BasicHorn();
		
	}

	@Override
	public void go() {
		if (engine.getGear() == Gear.PARK) {
			engine.setGear(Gear.DRIVE);
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
		if (engine.getThrottle() < Engine.MAX_THROTTLE) {
			engine.setThrottle(engine.getThrottle() + 1);
		} else {
			if (engine.getGear() == Gear.DRIVE) {
				engine.setGear(Gear.OVERDRIVE);
			}
		}
	}

	@Override
	public void slowDown() {
		if (engine.getGear() == Gear.PARK) {
			return;
		}
		
		if (engine.getGear() == Gear.OVERDRIVE){
			engine.setGear(Gear.DRIVE);
		} else {
			if (engine.getThrottle() > 0) {
				engine.setThrottle(engine.getThrottle()-1);
			}
		}
	}

	@Override
	public void honk() {
		horn.honk();
	}	
}
