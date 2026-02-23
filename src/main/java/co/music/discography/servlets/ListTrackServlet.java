package co.music.discography.servlets;

import co.music.discography.services.TrackService;
import co.music.discography.views.ListTrackView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

@WebServlet("/listTracks")
public class ListTrackServlet extends HttpServlet {

    private TrackService trackService;
    private ListTrackView listTrackView;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        trackService = context.getBean("trackService",TrackService.class);
        listTrackView = new ListTrackView();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>ListTrackServlet</title>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append(listTrackView.listTrackView(trackService.getTracks()));
        builder.append("</body>");
        builder.append("</html>");
        response.getWriter().write(builder.toString());
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
