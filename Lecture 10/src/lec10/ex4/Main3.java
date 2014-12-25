package lec10.ex4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main3 {

	public static void main(String[] args) {
		List<Song> slist = new ArrayList<Song>();

		Artist sk = new Artist("Sleater-Kinney");

		slist.add(new Song("Words and Guitar", sk));
		slist.add(new Song("Dig Me Out", sk));
		slist.add(new Song("Jenny", sk));
		slist.add(new Song("Little Babies", sk));
		slist.add(new Song("Buy Her Candy", sk));

		Iterator<Song> i1 = slist.iterator();
		Iterator<Song> i2 = slist.iterator();

		System.out.println("Iterator 1 next: " + i1.next().getName());
		System.out.println("Iterator 1 next: " + i1.next().getName());
		System.out.println("Iterator 2 next: " + i2.next().getName());
		System.out.println("Iterator 1 next: " + i1.next().getName());
		System.out.println("Iterator 2 next: " + i2.next().getName());
		System.out.println("Iterator 2 next: " + i2.next().getName());
		System.out.println("Iterator 2 next: " + i2.next().getName());
		System.out.println("Iterator 1 next: " + i1.next().getName());
		System.out.println("Iterator 1 next: " + i1.next().getName());

		System.out.println("Does i1 have another? -> " + i1.hasNext());
		System.out.println("Does i2 have another? -> " + i2.hasNext());

	}
}
