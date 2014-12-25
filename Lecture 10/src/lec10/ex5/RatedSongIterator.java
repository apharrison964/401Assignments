package lec10.ex5;

import java.util.Iterator;
import java.util.List;

public class RatedSongIterator implements Iterator<Song> {
        
        private List<Song> song_list;
        private int min_rating;
        private int cur_idx;
        
        public RatedSongIterator(List<Song> song_list, int min_rating) {
                this.song_list = song_list;
                this.min_rating = min_rating;
                cur_idx = 0;
        }
        
        public boolean hasNext() {
                if (cur_idx >= song_list.size()) return false;
                
                while (cur_idx < song_list.size()) {
                        if (song_list.get(cur_idx).getRating() >= min_rating) {
                                return true;
                        }
                        cur_idx += 1;
                }
                return false;
        }
        
        public Song next() {
                if (!hasNext()) {
                        throw new RuntimeException("No next song in iteration.");
                }
                Song s = song_list.get(cur_idx);
                cur_idx += 1;
                return s;
        }
        
        public void remove() {
                throw new RuntimeException("Remove operation unsupported.");
        }       
}
