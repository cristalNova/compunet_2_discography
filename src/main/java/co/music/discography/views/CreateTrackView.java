package co.music.discography.views;

import co.music.discography.model.Artist;

import java.util.List;

public class CreateTrackView {
    public String createTrackView(List<Artist> artistList) {
        StringBuilder content = new StringBuilder();

        content.append("<h1>Create Track</h1>");

        content.append("<form method=\"post\" action=\"/discography/createTrack\">");

        content.append("<label for=\"title\">Track Title:</label>");
        content.append("<input type=\"text\" id=\"title\" name=\"title\">");

        content.append("<br>");

        content.append("<label for=\"genre\">Genre:</label>");
        content.append("<input type=\"text\" id=\"genre\" name=\"genre\">");

        content.append("<br>");

        content.append("<label for=\"duration\">Duration:</label>");
        content.append("<input type=\"text\" id=\"duration\" name=\"duration\">");

        content.append("<br>");

        content.append("<label for=\"album\">Album:</label>");
        content.append("<input type=\"text\" id=\"album\" name=\"album\">");

        content.append("<br>");

        for (Artist artist : artistList) {
            content.append("<input type='checkbox' name='artists' value='")
                    .append(artist.getId())
                    .append("'>")
                    .append(artist.getName())
                    .append("<br>");
        }

        content.append("<input type=\"submit\" id=\"send\" value=\"Submit\">");

        content.append("</form>");

        return content.toString();
    }
}
