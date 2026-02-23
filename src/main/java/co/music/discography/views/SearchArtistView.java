package co.music.discography.views;

import co.music.discography.model.Artist;

public class SearchArtistView {

    public String searchArtistView() {

        StringBuilder content = new StringBuilder();

        content.append("<form method=\"get\" action=\"/discography/artist\">");
        content.append("<label for=\"name\">Artist Name:</label>");
        content.append("<input type=\"text\" id=\"name\" name=\"name\">");
        content.append("<br>");
        content.append("<input type=\"submit\" value=\"Search\">");

        return content.toString();
    }
}
