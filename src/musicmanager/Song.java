package musicmanager;


public class Song {
    private String title;
    private String artist;
    private String genre;
   
    // Constructor to initialize a Song object with title, artist, and genre
    public Song(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }
    
    
    // Method to get the title of the song
    public String getTitle() {
        return title;
    }

    // Method to get the artist of the song
    public String getArtist() {
        return artist;
    }

     // Method to get the genre of the song
    public String getGenre() {
        return genre;
    }
    
}
