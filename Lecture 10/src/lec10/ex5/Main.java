package lec10.ex5;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {

        public static void main(String[] args) {
                List<Song> slist = new ArrayList<Song>();

                slist.add(new Song("Macarena", 2));
                slist.add(new Song("Jenny", 3));
                slist.add(new Song("Little Babies", 4));
                slist.add(new Song("The Final Countdown", 1));
                slist.add(new Song("Buy Her Candy", 4));
                slist.add(new Song("Wannabe", 0));
                slist.add(new Song("Roar",3));
                slist.add(new Song("Words and Guitar", 5));
                slist.add(new Song("Barbie Girl", 1));
                slist.add(new Song("Firework", 4));
                slist.add(new Song("Dig Me Out", 5));

                System.out.println("Just the decent ones, please...");
                
                Iterator<Song> iter = new RatedSongIterator(slist, 3);
                
                while (iter.hasNext()) {
                        Song s = iter.next();
                        System.out.println(s.getName() + " (" + s.getRating() + ")");
                }
                
                System.out.println();
                System.out.println("Now the really good ones...");
                iter = new RatedSongIterator(slist, 4);

                while (iter.hasNext()) {
                    Song s = iter.next();
                    System.out.println(s.getName() + " (" + s.getRating() + ")");
            }
 
        }
}