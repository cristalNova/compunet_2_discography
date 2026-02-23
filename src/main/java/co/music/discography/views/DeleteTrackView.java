package co.music.discography.views;

public class DeleteTrackView {
    public String deleteTrackView(){
        StringBuilder content = new StringBuilder();
        content.append("<form method=\"post\" action=\"/discography/deleteTrack\">");
        content.append("<label for=\"id\">Track ID:</label>");
        content.append("<input type=\"text\" id=\"id\" name=\"id\">");
        content.append("<input type=\"submit\" value=\"Delete Track\">");
        content.append("</form>");

        return content.toString();

    }
}
