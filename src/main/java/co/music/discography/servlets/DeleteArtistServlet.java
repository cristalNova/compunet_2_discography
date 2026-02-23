package co.music.discography.servlets;

import co.music.discography.services.ArtistService;
import co.music.discography.views.DeleteArtistView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/deleteArtist")
public class DeleteArtistServlet extends HttpServlet {

    private DeleteArtistView deleteArtistView;
    private ArtistService artistService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        artistService = context.getBean("artistService",ArtistService.class);
        deleteArtistView = new DeleteArtistView();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>Artist Service</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append(deleteArtistView.deleteArtistView());
        builder.append("</body>");
        builder.append("</html>");

        response.getWriter().write(builder.toString());

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int artistId = Integer.parseInt(request.getParameter("id"));
        artistService.deleteArtist(artistId);
        response.sendRedirect(request.getContextPath() + "/listArtists");
    }

}
