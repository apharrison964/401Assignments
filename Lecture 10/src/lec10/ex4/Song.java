package lec10.ex4;

public class Song {
    private String name;
    private Artist artist;
    
    public Song(String name, Artist artist) {
            this.name = name;
            this.artist = artist;
    }
    
    public String getName() {
            return name;
    }
    
    public String getArtistName() {
            return artist.getName();
    }
}
