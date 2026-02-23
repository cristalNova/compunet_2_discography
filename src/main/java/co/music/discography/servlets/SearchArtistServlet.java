package co.music.discography.servlets;

import co.music.discography.views.SearchArtistView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/searchArtist")
public class SearchArtistServlet extends HttpServlet {
    private SearchArtistView searchArtistView;

    public void init() {
        searchArtistView = new SearchArtistView();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>Search Artist</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<h1>Search Artist</h1>");
        builder.append(searchArtistView.searchArtistView());
        builder.append("</body>");
        builder.append("</html>");

        resp.getWriter().write(builder.toString());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
