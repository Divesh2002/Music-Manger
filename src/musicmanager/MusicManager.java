package musicmanager;
import java.util.HashMap;
import java.util.Map;

public class MusicManager {
private Playlist likedPlaylist;
private Map<String, Playlist> genrePlaylists;

    public MusicManager() {
    // To store the liked playlist and genre playlist
     likedPlaylist = new Playlist();
     genrePlaylists = new HashMap<>();
    }
    
    // Method to add a song to the liked playlist
    public void addSongToLikedPlaylist(Song song) {
        likedPlaylist.addSong(song);
    }
    
    // Method to create genre playlists from the liked playlist
    public void createGenrePlaylists() {
        for (Song song : likedPlaylist.getSongs()) {
            String genre = song.getGenre();
    // If the genre playlist does not exist, create a new one
            if (!genrePlaylists.containsKey(genre)) {
                genrePlaylists.put(genre, new Playlist());
            }
    // Add the song to the corresponding genre playlist
            genrePlaylists.get(genre).addSong(song);
        }
    }
    // Method to add a song to a genre playlist
    public void addSongToGenrePlaylist(String genre, Song song) {
        if (genrePlaylists.containsKey(genre)) {
            genrePlaylists.get(genre).addSong(song);
        } else {
            System.out.println("Genre playlist for " + genre + " does not exist.");
        }
    }
    
    // Method to search for and print a song by title in either the liked playlist or genre playlists
    public void searchAndPrintSong(String title) {
        boolean found = false;
        // Search in Liked Playlist
        Song foundSong = likedPlaylist.searchSong(title);
        if (foundSong != null) {
            System.out.println("Song found in Liked Playlist: " + foundSong);
            found = true;
        }
        // Search in Genre Playlists
        for (Playlist playlist : genrePlaylists.values()) {
            foundSong = playlist.searchSong(title);
            if (foundSong != null) {
                System.out.println("Song found in Genre Playlist: " + foundSong);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Song not found.");
        }
    }
    // To delete a song from the liked playlist
    public void deleteSongFromLikedPlaylist(String title) {
        likedPlaylist.deleteSong(title);
    }

    // To move a song within the liked playlist
    public void moveSongInLikedPlaylist(int fromIndex, int toIndex) {
        likedPlaylist.moveSong(fromIndex, toIndex);
    }
    public Playlist getLikedPlaylist() {
        return likedPlaylist;
    }
    // Method to get the genre playlists
    public Map<String, Playlist> getGenrePlaylists() {
        return genrePlaylists;
    }

    void printPlaylists() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

