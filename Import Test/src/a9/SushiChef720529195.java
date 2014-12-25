package a9;
import comp401.sushi.*;

public class SushiChef720529195 implements SushiChef{
	
	private Plate plate;
	private double revenue = 0;
	private double outstanding = 0;
	private double purchasedPlateCost = 0;
	private double spoiledCost = 0;
	private double profit = 0;
	
	public SushiChef720529195(){

	}

	@Override
	public int getPID(){
		return 720529195;
	}

	@Override
	public String getName(){
		return "Chef Jiro";
	}
	
	@Override
	public Plate makePlate() {
		Sashimi sashimi =  new Sashimi(Sashimi.SashimiType.TUNA);
		try {
			plate = new BluePlate(sashimi);
			outstanding += plate.getContents().getCost();
		} catch (PlatePriceException e) {
			e.printStackTrace();
		}
		return plate;
	}

	@Override
	public void observePurchase(String customer, Plate plate, int chef_pid) {
		if(chef_pid == getPID()){
			purchasedPlateCost += plate.getContents().getCost();
			revenue += plate.getPrice();
		}
	}

	@Override
	public void observeSpoilage(Plate spoiledPlate, int chef_pid) {
		if(chef_pid == getPID()){
			spoiledCost += spoiledPlate.getContents().getCost();
		}
	}

	@Override
	public double getOutstandingCost() {
		return outstanding - spoiledCost - purchasedPlateCost;
	}

	@Override
	public double getProfit() {
		if(revenue < spoiledCost + purchasedPlateCost){
			return 0;
		}
		return revenue - spoiledCost - purchasedPlateCost;
	}

}
