package lec10.ex2;

public class Porsche911 implements Car {

	private ManualEngine engine;
	private FancyHorn horn;

	public Porsche911() {
		engine = new ManualEngine();
		horn = new FancyHorn();
	}
	
	@Override
	public void go() {
		if (engine.getGear() == Engine.Gear.PARK) {
			engine.setGear(Engine.Gear.FIRST);
			engine.setThrottle(1);
		}
	}

	@Override
	public void stop() {
		if (engine.getGear() != Engine.Gear.PARK) {
			engine.setThrottle(0);
			engine.setGear(Engine.Gear.PARK);
		}
	}

	@Override
	public void speedUp() {
		if (engine.getGear() == Engine.Gear.PARK) { 
			return;
		}
		if (engine.getThrottle() < Engine.MAX_THROTTLE) {
			engine.setThrottle(engine.getThrottle() + 1);
		} else if (engine.getGear() != Engine.Gear.FIFTH) {
			engine.setThrottle(engine.getThrottle() / 2);
			if (engine.getGear() == Engine.Gear.FIRST) {
				engine.setGear(Engine.Gear.SECOND);
			} else if (engine.getGear() == Engine.Gear.SECOND) {
				engine.setGear(Engine.Gear.THIRD);
			} else if (engine.getGear() == Engine.Gear.THIRD) {
				engine.setGear(Engine.Gear.FOURTH); 
			} else {
				engine.setGear(Engine.Gear.FIFTH);
			}
		}
	}

	@Override
	public void slowDown() {
		if (engine.getGear() == Engine.Gear.PARK) {
			return;
		}

		if ((engine.getThrottle() <= 5) &&
			(engine.getGear() != Engine.Gear.FIRST)) {
			engine.setThrottle(7);
			if (engine.getGear() == Engine.Gear.FIFTH) {
				engine.setGear(Engine.Gear.FOURTH);
			} else if (engine.getGear() == Engine.Gear.FOURTH) {
				engine.setGear(Engine.Gear.THIRD);
			} else if (engine.getGear() == Engine.Gear.THIRD){
				engine.setGear(Engine.Gear.SECOND);
			} else {
				engine.setGear(Engine.Gear.FIRST);
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
