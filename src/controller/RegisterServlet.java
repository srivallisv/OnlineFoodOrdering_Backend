package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 2. Print (for testing)
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        // 3. TEMP LOGIC (no DB yet)
        if (name != null && email != null && password != null) {

            // redirect to login page after registration
            response.sendRedirect("jsp/login.jsp");

        } else {
            response.sendRedirect("jsp/error.jsp");
        }
    }
}
