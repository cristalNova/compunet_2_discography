package co.music.discography.views;

import co.music.discography.model.Artist;
import co.music.discography.model.Track;

import java.util.List;

public class ListTrackView {
    public String listTrackView(List<Track> tracks) {
        StringBuilder content = new StringBuilder();
        content.append("<h1>List of Tracks</h1>");
        content.append("<table>");
        content.append("<tr>");
        content.append("<th>Id</th>");
        content.append("<th>Title</th>");
        content.append("<th>Genre</th>");
        content.append("<th>Duration</th>");
        content.append("<th>Album</th>");
        content.append("<th>Artist</th>");
        content.append("</tr>");
        for (Track track : tracks) {
            content.append("<tr>");
            content.append("<td>" + track.getId() + "</td>");
            content.append("<td>" + track.getTitle() + "</td>");
            content.append("<td>" + track.getGenre() + "</td>");
            content.append("<td>" + track.getDuration() + "</td>");
            content.append("<td>" + track.getAlbumTitle() + "</td>");
            content.append("<td>");
            content.append("<ul>");
            for (Artist artist : track.getArtists()) {
                content.append("<li>");
                content.append(artist.getName());
                content.append("</li>");
            }
            content.append("</ul>");
            content.append("</td>");
            content.append("</tr>");
        }
        content.append("</table>");
        return content.toString();
    }
}
