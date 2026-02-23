package co.music.discography.servlets;

import co.music.discography.config.AppConfiguration;
import co.music.discography.services.ArtistService;
import co.music.discography.services.TrackService;
import co.music.discography.views.CreateTrackView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/createTrack")
public class CreateTrackServlet extends HttpServlet {

    private CreateTrackView createTrackView;
    private ArtistService artistService;
    private TrackService trackService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        artistService = context.getBean(ArtistService.class);
        trackService = context.getBean(TrackService.class);
        createTrackView = new CreateTrackView();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>Create Track</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<h1>Create Track</h1>");
        builder.append(createTrackView.createTrackView(artistService.getArtists()));
        builder.append("</body>");
        builder.append("</html>");

        response.getWriter().write(builder.toString());
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String durationStr = request.getParameter("duration");
        String album = request.getParameter("album");
        String[] artistIds = request.getParameterValues("artists");
        double duration = 0.0;

        if (durationStr != null && durationStr.contains(":")) {
            String[] parts = durationStr.split(":");
            try {
                int minutes = Integer.parseInt(parts[0]);
                int seconds = Integer.parseInt(parts[1]);
                duration = minutes * 60 + seconds;
            } catch (NumberFormatException e) {
                //
            }
        }

        List<Integer> artistList = new ArrayList<>();

        if (artistIds != null) {
            for (String idStr : artistIds) {
                try {
                    int id = Integer.parseInt(idStr);
                    artistList.add(id);
                } catch (NumberFormatException e) {
                    //
                }
            }
        }

        trackService.addTrack(title,genre,duration,album,artistList);
        response.sendRedirect(request.getContextPath() + "/listTracks");
    }
}
