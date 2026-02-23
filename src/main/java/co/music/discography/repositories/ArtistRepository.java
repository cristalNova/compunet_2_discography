package co.music.discography.repositories;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;
import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;


public class ArtistRepository {

    private List<Artist> artists = new ArrayList<>();
    private int count = 0;

    public void init(){
        Artist artist = new Artist();
        artist.setName("Judeline");
        artist.setNationality("España");
        add(artist);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void add(Artist artist) {
        artist.setId(++count);
        artists.add(artist);
    }

    public Artist getArtistById(int id) {
        for (Artist artist : artists) {
            if (artist.getId() == id) {
                return artist;
            }
        }
        return null;
    }

    public Artist getArtistByName(String name) {
        for (Artist artist : artists) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < artists.size(); i++) {
            if (artists.get(i).getId() == id) {
                artists.remove(i);
                break;
            }
        }
    }

    public void setTrackToArtist(int id, Track track) {
        for (Artist artist : artists) {
            if (artist.getId() == id) {
                artist.addTrack(track);
            }
        }
    }
}
