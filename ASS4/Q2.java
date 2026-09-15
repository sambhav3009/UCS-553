import java.util.*;
class Song {
    String title;
    String artist;
    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }
        Song song = (Song) obj;
        return title.equals(song.title) && artist.equals(song.artist);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, artist);
    }
    @Override
    public String toString() {
        return title + " - " + artist;
    }
}
class MediaPlayer {
    LinkedList<Song> playlist = new LinkedList<>();
    LinkedList<Song> history = new LinkedList<>();
    void addSong(Song song) {
        playlist.add(song);
    }
    void addSongAt(int position, Song song) {
        if (position >= 0 && position <= playlist.size()) {
            playlist.add(position, song);
        }
    }
    void addPrioritySong(Song song) {
        playlist.addFirst(song);
    }
    void removeDuplicates() {
        HashSet<Song> uniqueSongs = new HashSet<>();
        ListIterator<Song> iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            Song song = iterator.next();
            if (!uniqueSongs.add(song)) {
                iterator.remove();
            }
        }
    }
    void playNext() {
        if (!playlist.isEmpty()) {
            Song song = playlist.removeFirst();
            history.addLast(song);
            System.out.println("Now Playing: " + song);
        }
    }
    void showForward() {
        ListIterator<Song> iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    void showBackward() {
        ListIterator<Song> iterator = playlist.listIterator(playlist.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
   void showHistory() {
        ListIterator<Song> iterator = history.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
public class Q2 {
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer();
        Song song1 = new Song("Blinding Lights", "The Weeknd");
        Song song2 = new Song("Perfect", "Ed Sheeran");
        Song song3 = new Song("Husn", "Anuv Jain");
        Song song4 = new Song("Kesariya", "Arijit Singh");
        Song song5 = new Song("Blinding Lights", "The Weeknd");
        player.addSong(song1);
        player.addSong(song2);
        player.addSong(song3);
        player.addSong(song5);
        player.addPrioritySong(song4);
        player.addSongAt(2, new Song("Chaleya", "Arijit Singh"));
        System.out.println("Playlist Forward:");
        player.showForward();
        System.out.println("\nPlaylist Backward:");
        player.showBackward();
        player.removeDuplicates();
        System.out.println("\nPlaylist After Removing Duplicates:");
        player.showForward();
        System.out.println("\nPlayback:");
        player.playNext();
        player.playNext();
        System.out.println("\nRecent History:");
        player.showHistory();
    }
}