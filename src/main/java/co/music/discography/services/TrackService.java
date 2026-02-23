package co.music.discography.services;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;
import co.music.discography.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    private TrackRepository repo;
    private ArtistService artistService;

    @Autowired
    public void setRepo(TrackRepository repo) {
        this.repo = repo;
    }
    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }
    public List<Track> getTracks() {
        return repo.getTracks();
    }

    public Track getTrack(int id) {
        return repo.getTrack(id);
    }

    public void addTrack(String title, String genre, double duration, String albumTitle, List<Integer> artists) {
        Track track = new Track();
        track.setTitle(title);
        track.setGenre(genre);
        track.setDuration(duration);
        track.setAlbumTitle(albumTitle);
        track.setArtists(addArtistToTrack(artists));
        repo.add(track);
        artistService.addTrackToArtist(artists, track);
    }

    public List<Artist> addArtistToTrack(List<Integer> artists) {
        List<Artist> artistList = new ArrayList<>();
        for (int i = 0; i < artists.size(); i++) {
            artistList.add(artistService.getArtistById(artists.get(i)));
        }
        return artistList;
    }

    public void deleteTrack(int id) {
        repo.delete(id);
    }
}
