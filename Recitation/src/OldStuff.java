import comp401.sushi.Avocado;
import comp401.sushi.BluePlate;
import comp401.sushi.Crab;
import comp401.sushi.Eel;
import comp401.sushi.GoldPlate;
import comp401.sushi.GreenPlate;
import comp401.sushi.Plate;
import comp401.sushi.PlatePriceException;
import comp401.sushi.RedPlate;
import comp401.sushi.Rice;
import comp401.sushi.Roll;
import comp401.sushi.Salmon;
import comp401.sushi.Shrimp;
import comp401.sushi.Tuna;


public class OldStuff {
	
	//ArrayList<Ingredient> ingreList = new ArrayList<Ingredient>();
			if(arg0.getSource() == avocadoSlider){
				//	avocadoSlider = test;
				if(((double) avocadoSlider.getValue() / 100.0) != 0){
					avocado = new Avocado((double) avocadoSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
				}
			} else if(arg0.getSource() == crabSlider){
				//	crabSlider = test;
				if(((double) crabSlider.getValue() / 100.0) != 0){
					crab = new Crab((double) crabSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
				}
			} else if(arg0.getSource() == eelSlider){
				//	eelSlider = test;
				if(((double) eelSlider.getValue() / 100.0) != 0){
					eel = new Eel((double) eelSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
				}
			} else if(arg0.getSource() == riceSlider){
				//	riceSlider = test;
				if(((double) riceSlider.getValue() / 100.0) != 0){
					rice = new Rice((double) riceSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
				}
			} else if(arg0.getSource() == salmonSlider){
				//	salmonSlider = test;
				if(((double) salmonSlider.getValue() / 100.0) != 0){
					salmon = new Salmon((double) salmonSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
				}
			} else if(arg0.getSource() == shrimpSlider){
				//	salmonSlider = test;
				if(((double) shrimpSlider.getValue() / 100.0) != 0){
					shrimp = new Shrimp((double) shrimpSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);
					System.out.println(ingreList);
				}
			} else if(arg0.getSource() == tunaSlider){
				//	salmonSlider = test;
				if(((double) tunaSlider.getValue() / 100.0) != 0){
					tuna = new Tuna((double) tunaSlider.getValue() / 100.0);
					ingreList.add(avocado);
					ingreList.add(crab);
					ingreList.add(eel);
					ingreList.add(rice);
					ingreList.add(salmon);
					ingreList.add(shrimp);
					ingreList.add(tuna);

				}
			}

			ingreList.add(avocado);
			ingreList.add(crab);
			ingreList.add(eel);
			ingreList.add(rice);
			ingreList.add(salmon);
			ingreList.add(shrimp);
			ingreList.add(tuna);

			//
			//		Ingredient[] ingredient = new Ingredient[ingreList.size()];
			//		ingredient = ingreList.toArray(ingredient);
			//		roll = new Roll(ingredient);
		}

Plate plate = null;
if(e.getSource() == makeRoll){
	roll = new Roll(ingredient);
	
	if(coloredPlates.getSelectedItem().toString().equals("Red Plate")){
		try {
			System.out.println(plate);
			plate = new RedPlate(roll);
			publishPlateToListeners(plate);
		} catch (PlatePriceException e1) {
			e1.printStackTrace();
		}
	}

	if(coloredPlates.getSelectedItem().toString().equals("Green Plate")){
		try {
			plate = new GreenPlate(roll);
			publishPlateToListeners(plate);
		} catch (PlatePriceException e1) {
			e1.printStackTrace();
		}
	}

	if(coloredPlates.getSelectedItem().toString().equals("Blue Plate")){
		try {
			plate = new BluePlate(roll);
			publishPlateToListeners(plate);
		} catch (PlatePriceException e1) {
			e1.printStackTrace();
		}
	}

	if(coloredPlates.getSelectedItem().toString().equals("Gold Plate")){
		try {
			plate = new GoldPlate(roll, goldAmount.getValue());
			publishPlateToListeners(plate);
		} catch (PlatePriceException e1) {
			e1.printStackTrace();
		}
	}
	
	
}

}

}
