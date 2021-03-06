package a2adept;

public class InvoiceItem {
	private String name;
	private double price_per_unit;
	private int unit_count;

	public InvoiceItem(String name, double price_per_unit, int unit_count) {

		this.name = name.trim(); // trimming name
		this.price_per_unit = price_per_unit;
		this.unit_count = unit_count;
		char[] charArray = this.name.toCharArray(); // setting a char array to see if it is upper case or not, etc.
		
		
		if (this.name.isEmpty()) {
			throw new RuntimeException("Illegal invoice item");
			}
		
		if (!Character.isUpperCase(charArray[0])) {     
			throw new RuntimeException("Illegal invoice item"); 
			}
		
		for(int i = 0; i < charArray.length; i++){
			if (!Character.isLetterOrDigit(charArray[i])) {  // getting the individual characters
				throw new RuntimeException("Illegal invoice item");
				}
		}
		
		if (price_per_unit <= 0) {
			throw new RuntimeException("Illegal invoice item");
			}

		if (unit_count <= 0) {
			throw new RuntimeException("Illegal invoice item");
			}
	}

	public String getName() {
		return this.name;
		}

	public double getPricePerUnit() {
		return price_per_unit;
		}

	public int getUnitCount() {
		return unit_count;
		}

	public double getCost() {
		return unit_count * price_per_unit;
		}

}
