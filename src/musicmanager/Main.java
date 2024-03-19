package musicmanager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating instance of MusicManager
        MusicManager manager = new MusicManager();
        Scanner scanner = new Scanner(System.in);

        // Menu for user interaction
        while (true) {
            System.out.println("====== Music Manager Menu ======");
            System.out.println("1. Add a songs to Liked Playlist");
            System.out.println("2. Create Genre Playlists");
            System.out.println("3. Add a song to a Genre Playlist");
            System.out.println("4. Search for a song");
            System.out.println("5. Delete a song from Liked Playlist");
            System.out.println("6. Move a song within Liked Playlist");
            System.out.println("7. Print a playlist");
            System.out.println("8. Show number of songs in each playlist");
            System.out.println("9. Set Repeat Option for Playlist");
            System.out.println("10. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

  switch (choice) {
      case 1: 
         // Adding a song to Liked Playlist
           System.out.println("Enter details for the song to add:");
           System.out.print("Title: ");
           String title = scanner.nextLine();
           System.out.print("Artist: ");
           String artist = scanner.nextLine();
           System.out.print("Genre: ");
           String genre = scanner.nextLine();
           Song newSong = new Song(title, artist, genre);
           manager.addSongToLikedPlaylist(newSong);
           System.out.println("Song added to Liked Playlist.");
           
      break;
      case 2:
     // Adding a song to Liked Playlist
             manager.createGenrePlaylists();
             System.out.println("Genre Playlists created.");
       
      break;
      case 3:
      // Adding a song to a Genre Playlist
              System.out.print("Enter genre to add the song: ");
               String genreToAdd = scanner.nextLine();
                System.out.print("Enter title of the song to add: ");
                  String titleToAdd = scanner.nextLine();
                    Song songToAdd = manager.getLikedPlaylist().searchSong(titleToAdd);
    
                if (songToAdd != null) {
                     manager.addSongToGenrePlaylist(genreToAdd, songToAdd);
                        System.out.println("Song added to Genre Playlist.");
                    } else {
                        System.out.println("Song not found in Liked Playlist.");
                    }
                  
        break;
        case 4:
             // Searching for a song
                System.out.print("Enter title of the song to search: ");
                  String titleToSearch = scanner.nextLine();
                    manager.searchAndPrintSong(titleToSearch);
                  
        break;
        case 5:
             // Deleting a song from Liked Playlist
                  System.out.print("Enter title of the song to delete from Liked Playlist: ");
                      String titleToDelete = scanner.nextLine();
                          manager.deleteSongFromLikedPlaylist(titleToDelete);
                              System.out.println("Song deleted from Liked Playlist.");
                   
        break;
        case 6:
             // Moving a song within Liked Playlist
                    System.out.print("Enter current index of the song to move within Liked Playlist: ");
                      int currentIndex = scanner.nextInt();
                      scanner.nextLine(); // Consume newline character
                      System.out.print("Enter new index for the song within Liked Playlist: ");
                      int newIndex = scanner.nextInt();
                     scanner.nextLine(); // Consume newline character
                     manager.moveSongInLikedPlaylist(currentIndex, newIndex);
                     System.out.println("Song moved within Liked Playlist.");
                    
         break;
         case 7:
                 // Printing a playlist
                    System.out.println("Which playlist do you want to print?");
                    System.out.println("1. Liked Playlist");
                    System.out.println("2. Genre Playlists");
                    int playlistChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                
                    if (playlistChoice == 1) {
                        System.out.println("Liked Playlist:");
                        manager.getLikedPlaylist().printPlaylist();
                    
                    } else if (playlistChoice == 2) {
                        System.out.println("Genre Playlists:");
                        for (String genreName : manager.getGenrePlaylists().keySet()) {
                            System.out.println(genreName + " Playlist:");
                            manager.getGenrePlaylists().get(genreName).printPlaylist();
                        }
                      } else {
                         System.out.println("Invalid choice.");
                     }
                    
          break;
          case 8:                  
                    // Showing number of songs in each playlist
                    System.out.println("Number of songs in Liked Playlist: " + manager.getLikedPlaylist().getNumberOfSongs());
                    for (String genreName : manager.getGenrePlaylists().keySet()) {
                    System.out.println("Number of songs in " + genreName + " Playlist: " + manager.getGenrePlaylists().get(genreName).getNumberOfSongs());
                    }
                    
          break;
          case 9:
              
                    // Setting Repeat Option for Playlist
                    System.out.println("Set Repeat Option for Playlist.");
                  
          break;
          case 10:
              
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    
          default:
                 // Handling invalid choices
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                    
            }
        }
    }
}
