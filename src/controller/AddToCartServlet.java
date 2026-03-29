package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String item = request.getParameter("itemName");
        String price = request.getParameter("price");
        String res = request.getParameter("res");

        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(item + " - Rs." + price);

        session.setAttribute("cart", cart);

        // go back to same menu
        response.sendRedirect("menu.jsp?res=" + res);
    }
}