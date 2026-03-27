package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.Restaurant;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        // TEMP DUMMY DATA (since DB not connected)
        Restaurant r = new Restaurant();
        r.setId(Integer.parseInt(id));
        r.setName("ABC Restaurant");
        r.setLocation("Chennai");

        // SEND OBJECT to JSP
        request.setAttribute("restaurant", r);

        request.getRequestDispatcher("jsp/restaurant.jsp").forward(request, response);
    }
}