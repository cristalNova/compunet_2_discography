package co.music.discography.views;

public class DeleteArtistView {

    public String deleteArtistView() {
        StringBuilder content = new StringBuilder();

        content.append("<form method=\"post\" action=\"/discography/deleteArtist\">");
        content.append("<label for=\"id\">Artist ID:</label>");
        content.append("<input type=\"text\" id=\"id\" name=\"id\">");
        content.append("<input type=\"submit\" value=\"Delete Artist\">");
        content.append("</form>");

        return content.toString();
    }
}
