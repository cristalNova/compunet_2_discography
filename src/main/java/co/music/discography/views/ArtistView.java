package co.music.discography.views;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;

import java.util.List;

public class ArtistView {

    public String artistView(Artist artist) {
        StringBuilder content = new StringBuilder();
        List<Track> tracks = artist.getTracks();

        content.append("<h1>Artist Information</h1>");
        content.append("<p>");
        content.append(artist.getName());
        content.append("</p>");
        content.append("<p>");
        content.append(artist.getNationality());
        content.append("</p>");
        content.append("<h2>Tracks</h2>");
        content.append("<ol>");
        for (Track track : tracks) {
            content.append("<li>");
            content.append(track.getTitle());
            content.append("</li>");
        }
        content.append("</ol>");

        return content.toString();
    }
}
