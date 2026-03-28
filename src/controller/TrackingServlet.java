package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/tracking")
public class TrackingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // You can pass dynamic status (optional)
        String status = "Your order is being prepared...";

        // Send to JSP
        request.setAttribute("status", status);

        request.getRequestDispatcher("jsp/tracking.jsp")
               .forward(request, response);
    }
}