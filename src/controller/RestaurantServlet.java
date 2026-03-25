package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.RestaurantDAO;
import model.Restaurant;

@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        RestaurantDAO dao = new RestaurantDAO();
        Restaurant r = dao.getRestaurantById(id);

        request.setAttribute("restaurant", r);
        request.getRequestDispatcher("restaurant.jsp").forward(request, response);
    }
}