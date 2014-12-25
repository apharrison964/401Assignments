package lec10.ex2;

public class HondaOdyssey implements Car {

	private AutomaticEngine engine;
	private BasicHorn horn;
	
	public HondaOdyssey() {
		engine = new AutomaticEngine();
		horn = new BasicHorn();
		
	}

	@Override
	public void go() {
		if (engine.getGear() == Engine.Gear.PARK) {
			engine.setGear(Engine.Gear.DRIVE);
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
		} else {
			if (engine.getGear() == Engine.Gear.DRIVE) {
				engine.setGear(Engine.Gear.OVERDRIVE);
			}
		}
	}

	@Override
	public void slowDown() {
		if (engine.getGear() == Engine.Gear.PARK) {
			return;
		}
		
		if (engine.getGear() == Engine.Gear.OVERDRIVE){
			engine.setGear(Engine.Gear.DRIVE);
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

//Composition
//Parts exist only to be part of the whole, instead of parts that exist on their own like in aggregation
//No setters or getters, do not make sense outside, functionality and state only accessible through the methods as
//a whole, encapsulated objects created internally, usually within the constructor
//These two methods are endpoints to a variety of solutions, delegation is more common with this
