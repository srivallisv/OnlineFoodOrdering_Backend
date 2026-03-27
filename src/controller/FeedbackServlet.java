package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get form data
            String userIdStr = request.getParameter("userId");
            String ratingStr = request.getParameter("rating");
            String comments = request.getParameter("comments");

            // Convert safely
            int userId = (userIdStr != null && !userIdStr.isEmpty())
                    ? Integer.parseInt(userIdStr) : 0;

            int rating = (ratingStr != null && !ratingStr.isEmpty())
                    ? Integer.parseInt(ratingStr) : 0;

            // 👉 TEMP: just print (no DB for now)
            System.out.println("User ID: " + userId);
            System.out.println("Rating: " + rating);
            System.out.println("Comments: " + comments);

            // Redirect to success page
            response.sendRedirect("jsp/success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp");
        }
    }
}