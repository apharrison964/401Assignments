package a2jedi;

import java.util.ArrayList;

public class Invoice {

	private String customer;
	private static int InvoiceNumber = 1;
	private int thisNum = InvoiceNumber;

	ArrayList<InvoiceItem> invoice; // Invoice array

	public Invoice(String customer) {

		invoice = new ArrayList<InvoiceItem>(); // instantiating invoice array
		this.customer = customer;
		thisNum = InvoiceNumber; // Taking the static invoice number and setting
									// it
		InvoiceNumber++; // Incrementing the static invoice number
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotalCost() {
		double totalCost = 0;
		for (InvoiceItem var : invoice)
			totalCost += var.getCost(); // Looping to find the total cost

		return totalCost;
	}

	public int getInvoiceNumber() {
		return thisNum; // Returning the invoice number
	}

	public InvoiceItem[] findItemsByNameFilter(String filter,
			boolean strict_prefix) {

		ArrayList<InvoiceItem> contains = new ArrayList<InvoiceItem>();

		for (InvoiceItem i : invoice) { // Using the array to add to the array
			if (strict_prefix) {
				if (i.getName().startsWith(filter)) { // Checking to the strict
														// prefix
					contains.add(i);
				}
			} else if (!strict_prefix) {
				if (i.getName().contains(filter))
					;
				contains.add(i);
			}
		}

		if (contains.isEmpty()) {
			return null;
		} else {
			InvoiceItem[] newContains = new InvoiceItem[contains.size()];
			for (int n = 0; n < contains.size(); n++) {
				newContains[n] = contains.get(n);
			}
			return newContains;
		}
	}

	public Invoice separateByNameFilter(String filter, boolean strict_prefix) {

		InvoiceItem[] contains = findItemsByNameFilter(filter, strict_prefix);

		if (contains == null) {
			return null;
		}

		Invoice newContains2 = new Invoice(getCustomer());
		for (int m = 0; m < contains.length; m++) {
			newContains2.addToInvoice(contains[m]);
			invoice.remove(contains[m]); // Whole thing is for the separate
											// filter
		}
		return newContains2;

	}

	public InvoiceItem findItemByName(String name) {
		for (int i = 0; i < invoice.size(); i++) { // finding by name
			if (invoice.get(i).getName().equals(name)) {
				return invoice.get(i);
			}
		}

		return null;
	}

	public InvoiceItem removeFromInvoice(String name) {
		for (int i = 0; i < invoice.size(); i++) { // removing from invoice
			if (invoice.get(i).getName().equals(name)) {
				return invoice.remove(i);
			}
		}
		return null;
	}

	public InvoiceItem addToInvoice(InvoiceItem new_item) {

		InvoiceItem oldStuff = findItemByName(new_item.getName());
		if (oldStuff == null) {
			invoice.add(new_item);
		} else {
			double existingCost = oldStuff.getCost();
			double newCost = new_item.getCost();
			int newCount = new_item.getUnitCount();
			int existingUnitCount = oldStuff.getUnitCount();

			invoice.remove(oldStuff);

			int newUnitCount = existingUnitCount + newCount;
			double newTotalCost = existingCost + newCost;
			double rightPrice = (newTotalCost) / (newUnitCount);

			new_item = new InvoiceItem(new_item.getName(), rightPrice,
					newUnitCount);

			invoice.add(new_item);

			return new_item; // adding the new updated items to the invoice

		}
		return null;
	}

}
