package servlets;

import mongo.service.MongoDBService;
import utils.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by artur on 16/05/17.
 */
public class FrontendServlet extends HttpServlet {

    private String user = "";
    private String assessment = "";

    private MongoDBService db = new MongoDBService();

    public FrontendServlet () throws ServletException {
        db.initialize("localhost", 27017, "testJavaMongo");
        super.init();
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        user = request.getParameter("user");
        assessment = request.getParameter("assessment");

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("user", user == null || assessment == null ? "" : user + ' ' +  assessment);
        response.getWriter().println(PageGenerator.instance().getPage("user.html", pageVariables));
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        user = request.getParameter("user");
        assessment = request.getParameter("assessment");


        db.insert("users", new Document("user", user).append("assessment", assessment));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("user", user == null || assessment == null ? "" : user + ' ' +  assessment);
        response.getWriter().println(PageGenerator.instance().getPage("user.html", pageVariables));
    }
}