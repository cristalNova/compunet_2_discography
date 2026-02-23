package co.music.discography.views;

public class CreateArtistView {

    public String getCreationArtistView (){
        StringBuilder content = new StringBuilder();

        content.append("<h1>Create Artist</h1>");

        content.append("<form method=\"post\" action=\"/discography/createArtist\">");

        content.append("<label for=\"name\">Artist Name:</label>");
        content.append("<input type=\"text\" id=\"name\" name=\"name\">");

        content.append("<br>");

        content.append("<label for=\"nationality\">Nationality:</label>");
        content.append("<input type=\"text\" id=\"nationality\" name=\"nationality\">");

        content.append("<br>");

        content.append("<input type=\"submit\" id=\"send\" value=\"Submit\">");

        content.append("</form>");

        return content.toString();
    }
}
