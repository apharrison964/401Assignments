package testers;

import a2adept.Invoice;
import a2adept.InvoiceItem;


public class AdeptTester {
	public static void main(String[] args) {
		double invoice_item_points_off = test_invoice_item();
		
		if (invoice_item_points_off > 1.5) {
			invoice_item_points_off = 1.5;
		}
		
		double invoice_points_off = test_invoice_simple();
		
		double score = Math.max(4.0-invoice_item_points_off-invoice_points_off, 0.0);
		System.out.println("TESTRESULT: " + score);
	}

	public static double test_invoice_simple() {
		boolean has_errors = false;
		double points_off = 0.0;
		
		Invoice invoice = new Invoice("Hari Kondabolu");
		
		if (!invoice.getCustomer().equals("Hari Kondabolu")) {
			System.err.println("Something is wrong with getCustomer()");
			points_off += 1.0;
			has_errors = true;
		}
		
		if (Math.abs(invoice.getTotalCost()) > 0.001) {
			System.err.println("Getting total cost of an empty invoice should be 0.0");
			points_off += 1.0;
			has_errors = true;
		}
		
		InvoiceItem item = new InvoiceItem("Apples", 0.50, 10);
		invoice.addToInvoice(item);
		
		if (invoice.findItemByName("Apples") != item) {
			System.err.println("Couldn't find previously added item");
			points_off += 1.0;
			has_errors = true;
		}
		
		if (Math.abs(invoice.getTotalCost()-5) > 0.001) {
			System.err.println("Getting total cost of invoice at this point should be 5.0");
			points_off += 1.0;
			has_errors = true;
		}

		invoice.addToInvoice(new InvoiceItem("Apples", 1.00, 10));
		
		InvoiceItem new_apples = invoice.findItemByName("Apples");
		if (new_apples == null) {
			System.err.println("Expected an invoice item, but got null");
			points_off += 1.0;
			has_errors = true;
		} else {
			if (new_apples.getUnitCount() != 20) {
				System.err.println("Expected 20 apples but got: " + new_apples.getUnitCount());
				points_off += 2.0;
				has_errors = true;
			}
			if (Math.abs(new_apples.getCost()-15) > 0.001) {
				System.err.println("Expected cost of apples to be 15.0 but got: " + new_apples.getCost());
				points_off += 1.5;
				has_errors = true;
			}
			if (Math.abs(new_apples.getPricePerUnit()-0.75) > 0.001) {
				System.err.println("Expected cost of apples to be 0.75 but got: " + new_apples.getCost());
				points_off += 1.5;
				has_errors = true;
			}
		}
		
		InvoiceItem bad_item  = invoice.findItemByName("Bogus");
		if (bad_item != null) {
			System.err.println("Did not expect an invoice item, but got one");
			points_off += 1.0;
			has_errors = true;			
		}

		InvoiceItem removed_apples = invoice.removeFromInvoice("Apples");
		if (removed_apples == null) {
			System.err.println("Expected reference to removed item, but got null");
			points_off += 1.0;
			has_errors = true;
		} else {
			if (removed_apples != new_apples) {
				System.err.println("Expected removed item to be same as previously found item");
				points_off += 1.0;
				has_errors = true;
			}
		}
		
		if (Math.abs(invoice.getTotalCost()) > 0.001) {
			System.err.println("Expected cost to now be 0.0");
			points_off += 1.5;
			has_errors = true;
		}

		if (!has_errors) {
			System.err.println("Passed adept tests for Invoice");
		}
		return points_off;
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
