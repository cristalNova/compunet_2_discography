package co.music.discography.model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private int id;
    private String title;
    private String genre;
    private double duration;
    private String albumTitle;

    private List<Artist> artists = new ArrayList<>();

    public Track(int id, String title, String genre, double duration, String albumTitle) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.albumTitle = albumTitle;
    }

    public Track() {}

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getGenre() {
        return genre;
    }
    public double getDuration() {
        return duration;
    }
    public String getAlbumTitle() {
        return albumTitle;
    }
    public List<Artist> getArtists() {
        return artists;
    }
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}
