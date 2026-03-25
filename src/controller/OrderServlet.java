package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from request
        int id = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        double total = Double.parseDouble(request.getParameter("total"));

        // Create Order object
        Order order = new Order();
        order.setId(id);
        order.setUserId(userId);
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new Date());
        order.setTotal(total);

        // Call DAO
        OrderDAO dao = new OrderDAO();
        boolean status = dao.addOrder(order);

        // Redirect based on result
        if (status) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
