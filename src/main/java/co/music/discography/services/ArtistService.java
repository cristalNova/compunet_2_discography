package co.music.discography.services;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;
import co.music.discography.repositories.ArtistRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {


    private ArtistRepository repo;
    private TrackService trackService;

    @Autowired
    public void setArtistRepository(ArtistRepository repo) {
        this.repo = repo;
    }
    @Autowired
    public void setTrackService(TrackService trackService) {this.trackService = trackService;}
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
        Artist artist = repo.getArtistById(id);
        List<Track> tracks = artist.getTracks();
        trackService.deleteArtistFromTrack(id, tracks);
        repo.delete(id);
    }
    public void addTrackToArtist(List<Integer> artists, Track track) {
        for (int i = 0; i < artists.size(); i++) {
            repo.setTrackToArtist(artists.get(i), track);
        }
    }
    public void deleteTrackFromArtist(List<Artist> artists, Track track) {
        for (int i = 0; i < artists.size(); i++) {
            repo.deleteTrackFromArtist(artists.get(i).getId(), track);
        }
    }



}
