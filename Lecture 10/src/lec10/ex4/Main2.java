package lec10.ex4;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main2 {

	public static void main(String[] args) {
		List<Song> sk_list = new ArrayList<Song>();

		Artist sk = new Artist("Sleater-Kinney");

		sk_list.add(new Song("Words and Guitar", sk));
		sk_list.add(new Song("Dig Me Out", sk));
		sk_list.add(new Song("Jenny", sk));             
		sk_list.add(new Song("Little Babies", sk));
		sk_list.add(new Song("Buy Her Candy", sk));

		List<Song> mm_list = new ArrayList<Song>();

		Artist mm = new Artist("Minutemen");

		mm_list.add(new Song("Two Beads at the End", mm));
		mm_list.add(new Song("Toadies", mm));
		mm_list.add(new Song("Corona", mm));
		mm_list.add(new Song("History Lesson - Part II", mm));
		mm_list.add(new Song("June 16th", mm));         

		Iterator<Song> sk_iter = sk_list.iterator();
		Iterator<Song> mm_iter = mm_list.iterator();

		while (sk_iter.hasNext() && mm_iter.hasNext()) {
			Song next_song;
			if (Math.random() > 0.5) {
				next_song = sk_iter.next();
			} else {
				next_song = mm_iter.next();
			}
			System.out.println("Next song: " + next_song.getName() + 
					", by " + next_song.getArtistName());

		}

		Iterator<Song> leftovers;
		if (sk_iter.hasNext()) {
			leftovers = sk_iter;
		} else {
			leftovers = mm_iter;
		}

		while (leftovers.hasNext()) {
			Song next_song = leftovers.next();
			System.out.println("Next song: " + next_song.getName() + 
					", by " + next_song.getArtistName());
		}
	}
}
