package a2adept;

import java.util.ArrayList;

public class Invoice {

	private String customer;

	ArrayList<InvoiceItem> invoice;

	public Invoice(String customer) {

		invoice = new ArrayList<InvoiceItem>();
		this.customer = customer;
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotalCost() {
		double totalCost = 0;
		for (InvoiceItem var : invoice)
			totalCost += var.getCost();
		return totalCost;
	}

	public InvoiceItem findItemByName(String name) {
		for (int i = 0; i < invoice.size(); i++) {
			if (invoice.get(i).getName().equals(name)) {
				return invoice.get(i);
			}

		}

		return null;
	}

	public InvoiceItem removeFromInvoice(String name) {
		for (int i = 0; i < invoice.size(); i++) {
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
			return new_item;

		}
		return null;
	}
}
