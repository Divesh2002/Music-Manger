package musicmanager;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private ArrayList<Song> songs;

    // Constructor
    public Playlist() {
    // To store songs in the playlist
    songs = new ArrayList<>();
    }

    // Add a song to the playlist
     public void addSong(Song song) {
     songs.add(song);
    }
     
     // Get all songs in the playlist
    public List<Song> getSongs() {
        return songs;
    }
    
    // Search for a song by title
    public Song searchSong(String title) {
       for (Song song : songs) {
          if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    // Delete a song from the playlist
    public void deleteSong(String title) {
      Song song = searchSong(title);
         if (song != null) {
             songs.remove(song);
        }
    }

    // Print the playlist
    public void printPlaylist() {
        for (Song song : songs) {
            System.out.println(song.getTitle() + " - " + song.getArtist());
        }
    }

    // Get the number of songs in the playlist
    public int getNumberOfSongs() {
        return songs.size();
    }

    // Move song to a specific index
    public void moveSong(int fromIndex, int toIndex) {
        if (fromIndex >= 0 && fromIndex < songs.size() && toIndex >= 0 && toIndex < songs.size()) {
            Song song = songs.remove(fromIndex);
            songs.add(toIndex, song);
        }
    }

    // Get the last added song
    public Song getLastAddedSong() {
        if (!songs.isEmpty()) {
            return songs.get(songs.size() - 1);
        }
        return null;
    }

    // Get song at a specific index
    public Song getSongAtIndex(int index) {
        if (index >= 0 && index < songs.size()) {
            return songs.get(index);
        }
        return null;
    }

    // Clear the playlist
    public void clear() {
        songs.clear();
    }
}
    
    
    

