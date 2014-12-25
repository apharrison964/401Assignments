package lec10.ex2;

public class FancyHorn implements AdjustableHorn {

	private int volume;
	
	FancyHorn() {
		volume = 1;
	}
	
	@Override
	public void honk() {
		String noise = "";
		
		switch (volume) {
		case 1:
			noise = "beep";
			break;
		case 2:
			noise = "BEEEEEEP";
			break;
		case 3:
			noise = "HHHHHHHOOOOOOONNNNNNNKKKKKKK";
			break;
		}
		System.out.println(noise);
	}

	@Override
	public int getHornVolume() {
		return volume;
	}

	@Override
	public void setHornVolume(int v) {
		if (v < 1 || v > 3) {
			throw new RuntimeException("Illegal volume setting");
		}
		volume = v;
	}

}
