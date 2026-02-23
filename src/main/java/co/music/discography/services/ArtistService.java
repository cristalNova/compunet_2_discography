package co.music.discography.services;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;
import co.music.discography.repositories.ArtistRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;

import java.util.List;

public class ArtistService {

    private ArtistRepository repo;


    public void setArtistRepository(ArtistRepository repo) {
        this.repo = repo;
    }
    public List<Artist> getArtists() {
        return repo.getArtists();
    }
    public Artist getArtistByName(String name) {
        return repo.getArtistByName(name);
    }
    public Artist getArtistById(int id) {
        return repo.getArtistById(id);
    }
    public void addArtist(String artistName, String nationality) {
        Artist artist = new Artist();
        artist.setName(artistName);
        artist.setNationality(nationality);
        repo.add(artist);
    }
    public void deleteArtist(int id) {
        repo.delete(id);
    }
    public void addTrackToArtist(List<Integer> artists, Track track) {
        for (int i = 0; i < artists.size(); i++) {
            repo.setTrackToArtist(artists.get(i), track);
        }
    }



}
