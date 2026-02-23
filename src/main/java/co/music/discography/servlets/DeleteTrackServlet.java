package co.music.discography.servlets;

import co.music.discography.config.AppConfiguration;
import co.music.discography.services.TrackService;
import co.music.discography.views.DeleteTrackView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/deleteTrack")
public class DeleteTrackServlet extends HttpServlet {

    private TrackService trackService;
    private DeleteTrackView deleteTrackView;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        trackService = context.getBean(TrackService.class);
        deleteTrackView = new DeleteTrackView();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html\">");
        builder.append("<title>Delete Track By ID</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<h1>Track ID</h1>");
        builder.append(deleteTrackView.deleteTrackView());
        builder.append("</body>");
        builder.append("</html>");
        resp.getWriter().print(builder.toString());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        trackService.deleteTrack(id);

        resp.sendRedirect(req.getContextPath() + "/listTracks");
    }

}
