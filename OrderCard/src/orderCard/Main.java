package orderCard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main  {


	public static void main(String[] args){

		String approvedName;
		String authorName;
		int edition = 0;
		String fundName;
		String imprintName;
		double ISBNnum = 1;
		String location;
		int OCLC = 0;
		double price = 0;
		String title;

		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		authorName = Author.getFullName(sc.next());
		approvedName = ApprovedBy.getApprovedBy(sc.next());
		fundName = Fund.getFundName(sc.next());
		imprintName = Imprint.getImprint(sc.next());
		location = Location.getLocation(sc.next());
		title = Title.getTitle(sc.next());

		try {
			price = Price.getPrice(sc.nextDouble());
		} catch (PriceException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}

		try {
			OCLC = OCLCNumber.getOCLC(sc.nextInt());
		} catch (OCLCPriceException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			ISBNnum = ISBN.getISBN(sc.nextDouble());
		} catch (ISBNNumberLessException | ISBNNumberGreaterException
				| ISBNNumberNotValidException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			edition = Edition.getEdition(sc.nextInt());
		} catch (EditionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("working");

		try {
			File file = new File("OrderCard.txt");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			output.write(approvedName);
			output.write(authorName);
			output.write(edition);
			output.write(fundName);
			output.write(imprintName);
			output.write((int) ISBNnum);
			output.write(location);
			output.write(OCLC);
			output.write((int) price);
			output.write(title);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
