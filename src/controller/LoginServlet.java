package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.getWriter().println("<h2>Login Servlet is Working!</h2>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Dummy validation (you can later connect DB)
        if ("admin@gmail.com".equals(email) && "1234".equals(password)) {

            // Redirect to restaurant page
            response.sendRedirect("restaurant?id=1");

        } else {

            // If login fails
            response.sendRedirect("jsp/error.jsp");
        }
    }
}