package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get parameters safely
            String idStr = request.getParameter("id");
            String userIdStr = request.getParameter("userId");
            String restaurantIdStr = request.getParameter("restaurantId");
            String totalStr = request.getParameter("total");

            // Convert safely (avoid crash)
            int id = (idStr != null && !idStr.isEmpty()) ? Integer.parseInt(idStr) : 0;
            int userId = (userIdStr != null && !userIdStr.isEmpty()) ? Integer.parseInt(userIdStr) : 0;
            int restaurantId = (restaurantIdStr != null && !restaurantIdStr.isEmpty()) ? Integer.parseInt(restaurantIdStr) : 0;
            double total = (totalStr != null && !totalStr.isEmpty()) ? Double.parseDouble(totalStr) : 0.0;

            // Create Order object
            Order order = new Order();
            order.setId(id);
            order.setUserId(userId);
            order.setRestaurantId(restaurantId);
            order.setOrderDate(new Date());
            order.setTotal(total);

            // ✅ TEMP: Skip DB for now
            response.sendRedirect("jsp/success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp");
        }
    }
}