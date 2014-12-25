package lec10.ex4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main1 {
	public static void main(String[] args) {
		List<Song> slist = new ArrayList<Song>();

		Artist sk = new Artist("Sleater-Kinney");

		slist.add(new Song("Words and Guitar", sk));
		slist.add(new Song("Dig Me Out", sk));
		slist.add(new Song("Jenny", sk));               
		slist.add(new Song("Little Babies", sk));
		slist.add(new Song("Buy Her Candy", sk));
		// See lecture slide "Main 1 Visualized (1)" here

		Iterator<Song> iter = slist.iterator();
		// See lecture slide "Main 1 Visualized (2)" here

		while (iter.hasNext()) {   
			// See lecture slide "Main 1 Visualized (3)" here

			Song next_song = iter.next();
			// See lecture slide "Main 1 Visualized(4)" here.

			System.out.println("The next song: " + next_song.getName());
		}
	}
}
