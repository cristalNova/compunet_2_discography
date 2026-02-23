package co.music.discography.views;

import co.music.discography.model.Artist;

import java.util.List;

public class ListArtistView{

    public String getListArtistsView(List<Artist> artists){
        StringBuilder content = new StringBuilder();

        content.append("<table>");
        content.append("<tr>");
        content.append("<th>Artist ID</th>");
        content.append("<th>Artist Name</th>");
        content.append("<th>Nationality</th>");
        content.append("</tr>");
        for(Artist artist : artists){
            content.append("<tr>");
            content.append("<td>");
            content.append(artist.getId());
            content.append("</td>");
            content.append("<td>");
            content.append(artist.getName());
            content.append("</td>");
            content.append("<td>");
            content.append(artist.getNationality());
            content.append("</td>");
            content.append("</tr>");
        }
        content.append("</table>");

        return content.toString();
    }


}
