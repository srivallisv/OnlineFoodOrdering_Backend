package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // Get form data
            String itemName = request.getParameter("itemName");
            String quantityStr = request.getParameter("quantity");
            String priceStr = request.getParameter("price");

            // Convert safely
            int quantity = (quantityStr != null && !quantityStr.isEmpty())
                    ? Integer.parseInt(quantityStr) : 0;

            double price = (priceStr != null && !priceStr.isEmpty())
                    ? Double.parseDouble(priceStr) : 0.0;

            // Calculate total
            double total = quantity * price;

            // TEMP: print (for checking)
            System.out.println("Item: " + itemName);
            System.out.println("Quantity: " + quantity);
            System.out.println("Price: " + price);
            System.out.println("Total: " + total);

            // Send data to next page (optional)
            request.setAttribute("itemName", itemName);
            request.setAttribute("quantity", quantity);
            request.setAttribute("total", total);

            // Forward to order confirmation OR success
            request.getRequestDispatcher("jsp/orderconfirmation.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("jsp/error.jsp");
        }
    }
}