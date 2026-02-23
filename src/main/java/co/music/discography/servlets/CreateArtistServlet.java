package co.music.discography.servlets;


import co.music.discography.model.Track;
import co.music.discography.services.ArtistService;
import co.music.discography.views.CreateArtistView;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/createArtist")
public class CreateArtistServlet extends HttpServlet {

    private ArtistService artistService;
    private CreateArtistView artistView;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        gson = new Gson();
        artistService = context.getBean("artistService",ArtistService.class);
        artistView = new CreateArtistView();

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<body>");
        builder.append(artistView.getCreationArtistView());
        builder.append("</body>");
        builder.append("</html>");

        resp.getWriter().println(builder.toString());

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nameArtist = req.getParameter("name");
        String nationality = req.getParameter("nationality");

        artistService.addArtist(nameArtist, nationality);

        resp.sendRedirect(req.getContextPath() + "/listArtists");

    }

}
