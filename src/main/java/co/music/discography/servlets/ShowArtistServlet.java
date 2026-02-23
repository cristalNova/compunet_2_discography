package co.music.discography.servlets;

import co.music.discography.services.ArtistService;
import co.music.discography.views.ArtistView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/artist")
public class ShowArtistServlet extends HttpServlet {

    private ArtistService artistService;
    private ArtistView artistView;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        artistService = context.getBean("artistService",ArtistService.class);
        artistView = new ArtistView();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>Artist Service</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append(artistView.artistView(artistService.getArtistByName(req.getParameter("name"))));
        builder.append("</body>");
        builder.append("</html>");

        resp.getWriter().print(builder.toString());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
