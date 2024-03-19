package musicmanager;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MusicManagerGUI extends JFrame {

    private MusicManager manager;
    
    // GUI Components
    private JTextArea outputTextArea;
    private JTextField titleField, artistField, genreField, searchField, deleteField, moveFromField, moveToField;
    private JButton addButton, createGenrePlaylistsButton, searchButton, deleteButton, moveButton, printButton;
   
    // Constructor
    public MusicManagerGUI() {
    // Initialize MusicManager
    manager = new MusicManager();

    // Set up the JFrame
       setTitle("Music Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Create JTextArea for output
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        
        // Create JPanel for input components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Add input components to inputPanel
        inputPanel.add(new JLabel("Title: "));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Artist: "));
        artistField = new JTextField();
        inputPanel.add(artistField);

        inputPanel.add(new JLabel("Genre: "));
        genreField = new JTextField();
        inputPanel.add(genreField);

        inputPanel.add(new JLabel("Search: "));
        searchField = new JTextField();
        inputPanel.add(searchField);

        inputPanel.add(new JLabel("Delete: "));
        deleteField = new JTextField();
        inputPanel.add(deleteField);

        inputPanel.add(new JLabel("Move from: "));
        moveFromField = new JTextField();
        inputPanel.add(moveFromField);

        inputPanel.add(new JLabel("Move to: "));
        moveToField = new JTextField();
        inputPanel.add(moveToField);
        
        // Create JPanel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
        // Add buttons to buttonPanel
        addButton = new JButton("Add Song");
        createGenrePlaylistsButton = new JButton("Create Genre Playlists");
        searchButton = new JButton("Search Song");
        deleteButton = new JButton("Delete Song");
        moveButton = new JButton("Move Song");
        printButton = new JButton("Print Playlists");

        buttonPanel.add(addButton);
        buttonPanel.add(createGenrePlaylistsButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(moveButton);
        buttonPanel.add(printButton);

        // Add action listeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String artist = artistField.getText();
                String genre = genreField.getText();
                manager.addSongToLikedPlaylist(new Song(title, artist, genre));
                outputTextArea.append("Song added: " + title + " by " + artist + " (" + genre + ")\n");
                clearInputFields();
            }
        });

        createGenrePlaylistsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.createGenrePlaylists();
                outputTextArea.append("Genre playlists created.\n");
                clearInputFields();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                manager.searchAndPrintSong(searchTerm);
                clearInputFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titleToDelete = deleteField.getText();
                manager.deleteSongFromLikedPlaylist(titleToDelete);
                outputTextArea.append("Song deleted from Liked Playlist.\n");
                clearInputFields();
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fromIndex = Integer.parseInt(moveFromField.getText());
                int toIndex = Integer.parseInt(moveToField.getText());
                manager.moveSongInLikedPlaylist(fromIndex, toIndex);
                outputTextArea.append("Song moved within Liked Playlist.\n");
                clearInputFields();
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.printPlaylists();
            }
        });

        // Add GUI components to JFrame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Display the JFrame
        setVisible(true);
    }
    
      // Method to clear input fields
    private void clearInputFields() {
        titleField.setText("");
        artistField.setText("");
        genreField.setText("");
        searchField.setText("");
        deleteField.setText("");
        moveFromField.setText("");
        moveToField.setText("");
    }

 // Main method to run the GUI
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MusicManagerGUI musicManagerGUI = new MusicManagerGUI();
                musicManagerGUI.setVisible(true);
                // Ensure the GUI is visible
            }
        });
    }
}
