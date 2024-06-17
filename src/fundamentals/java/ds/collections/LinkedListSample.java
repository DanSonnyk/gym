package fundamentals.java.ds.collections;

import java.util.LinkedList;
import java.util.ListIterator;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

public class LinkedListSample {
    private LinkedList<Song> playlist;

    public LinkedListSample() {
        playlist = new LinkedList<>();
    }

    // Add a song to the end of the playlist
    public void addSong(Song song) {
        playlist.add(song);
    }

    // Add a song at a specific position
    public void addSong(int position, Song song) {
        if (position < 0 || position > playlist.size()) {
            System.out.println("Invalid position");
        } else {
            playlist.add(position, song);
        }
    }

    // Remove a song by position
    public void removeSong(int position) {
        if (position < 0 || position >= playlist.size()) {
            System.out.println("Invalid position");
        } else {
            playlist.remove(position);
        }
    }

    // Print all songs in the playlist
    public void showPlaylist() {
        ListIterator<Song> iterator = playlist.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        LinkedListSample myLinkedListSample = new LinkedListSample();

        Song song1 = new Song("Imagine", "John Lennon");
        Song song2 = new Song("Hey Jude", "The Beatles");
        Song song3 = new Song("Bohemian Rhapsody", "Queen");

        myLinkedListSample.addSong(song1);
        myLinkedListSample.addSong(song2);
        myLinkedListSample.addSong(song3);

        System.out.println("Initial playlist:");
        myLinkedListSample.showPlaylist();

        Song song4 = new Song("Purple Haze", "Jimi Hendrix");
        myLinkedListSample.addSong(1, song4);

        System.out.println("\nPlaylist after adding a song at position 1:");
        myLinkedListSample.showPlaylist();

        myLinkedListSample.removeSong(2);

        System.out.println("\nPlaylist after removing the song at position 2:");
        myLinkedListSample.showPlaylist();
    }
}

