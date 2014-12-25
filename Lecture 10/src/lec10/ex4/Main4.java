package lec10.ex4;

import java.util.List;
import java.util.ArrayList;

public class Main4 {

	public static void main(String[] args) {
		List<Song> slist = new ArrayList<Song>();

		Artist sk = new Artist("Sleater-Kinney");

		slist.add(new Song("Words and Guitar", sk));
		slist.add(new Song("Dig Me Out", sk));
		slist.add(new Song("Jenny", sk));
		slist.add(new Song("Little Babies", sk));
		slist.add(new Song("Buy Her Candy", sk));

		for (Song s : slist) {
			System.out.println("The next song: " + s.getName());
		}
	}
}
