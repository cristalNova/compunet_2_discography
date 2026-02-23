package co.music.discography.repositories;

import co.music.discography.model.Track;

import java.util.ArrayList;
import java.util.List;

public class TrackRepository {
    private List<Track> tracks = new ArrayList<>();
    private int count=0;

    public void add(Track track) {
        track.setId(++count);
        tracks.add(track);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Track getTrack(int id) {
        for (Track track : tracks) {
            if (track.getId() == id) {
                return track;
            }
        }
        return null;
    }

    public void delete(int id) {
        for (int i = 0; i < tracks.size(); i++) {
            if (tracks.get(i).getId() == id) {
                tracks.remove(i);
                break;
            }
        }
    }
}
