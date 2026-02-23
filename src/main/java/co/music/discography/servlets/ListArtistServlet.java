package co.music.discography.servlets;

import co.music.discography.services.ArtistService;
import co.music.discography.views.ListArtistView;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/listArtists")
public class ListArtistServlet  extends HttpServlet {

    private ListArtistView listArtistView;
    private ArtistService artistService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        artistService = context.getBean("artistService",ArtistService.class);
        listArtistView = new ListArtistView();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>List of artists</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<h1>List of artists</h1>");
        builder.append(listArtistView.getListArtistsView(artistService.getArtists()));
        builder.append("</body>");
        builder.append("</html>");

        response.getWriter().write(builder.toString());

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
