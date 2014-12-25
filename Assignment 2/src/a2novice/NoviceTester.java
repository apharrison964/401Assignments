package a2novice;


public class NoviceTester {
	public static void main(String[] args) {
		double points_off = test_invoice_item();
		
		double score = Math.max(2.0 - points_off,  0.0);
		System.out.println("TESTRESULT: " + score);
	}
	
	public static double test_invoice_item() {
		InvoiceItem item = new InvoiceItem("Blueberries", 3.75, 100);

		double points_off = 0.0;
		
		boolean has_errors = false;
		if (!item.getName().equals("Blueberries")) {
			System.err.println("Something is wrong with getName()");
			points_off += 0.25;
			has_errors = true;
		}
		
		if (Math.abs(item.getPricePerUnit()-3.75) > 0.001) {
			System.err.println("Something is wrong with getPricePerUnit()");
			points_off += 0.25;
			has_errors = true;
		}
		
		if (item.getUnitCount() != 100) {
			System.err.println("Something is wrong with getUnitCount()");
			points_off += 0.25;
			has_errors = true;
		}
		
		if (Math.abs((item.getCost() - 375)) > 0.001) {
			System.err.println("Something is wrong with getCost()");
			points_off += 0.25;
			has_errors = true;
		}
		
		try {
			InvoiceItem bad_item = new InvoiceItem("    ", 1, 1);
			System.err.println("Constructor allowed creation of item with empty name");
			points_off += 1.0;
			has_errors = true;
		}
		catch (RuntimeException e) {
		}
		
		try {
			InvoiceItem bad_item = new InvoiceItem("Blueberries", -1, 1);
			System.err.println("Constructor allowed creation of item with negative cost");
			points_off += 0.5;
			has_errors = true;
		}
		catch (RuntimeException e) {
		}

		try {
			InvoiceItem bad_item = new InvoiceItem("Blueberries", 1, 0);
			System.err.println("Constructor allowed creation of item with zero count");
			points_off += 0.25;
			has_errors = true;
		}
		catch (RuntimeException e) {
		}
		
		try {
			InvoiceItem bad_item = new InvoiceItem("blueberries", 1, 1);
			System.err.println("Constructor allowed creation of item with lowercase start of name");
			points_off += 0.25;
			has_errors = true;
		}
		catch (RuntimeException e) {
		}

		try {
			InvoiceItem bad_item = new InvoiceItem("Blue berries", 1, 1);
			System.err.println("Constructor allowed creation of item with illegal character in name");
			points_off += 0.25;
			has_errors = true;
		}
		catch (RuntimeException e) {
		}
		
		try {
			InvoiceItem good_item = new InvoiceItem("  Blueberries   ", 1, 1);
		} catch (Exception e) {
			System.err.println("Constructor should have allowed creation after spaces stripped from beginning and end.");
			points_off += 0.5;
			has_errors = true;
		}
		
		if (!has_errors) {
			System.err.println("InvoiceItem test passed.");
		} else {
			System.err.println("One or more InvoiceItem tests failed.");
		}
		return points_off;
	}

}
