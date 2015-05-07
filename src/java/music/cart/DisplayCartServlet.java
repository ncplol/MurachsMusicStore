package music.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;

public class DisplayCartServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        String quantityString = request.getParameter("quantity");
        String productCode = request.getParameter("productCode");
        String removeButtonValue = request.getParameter("removeButton");

        HttpSession session = request.getSession();
        
        Cart cart = (Cart) session.getAttribute("cart");  
        if (cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // If the user enters a negative or invalid number in the
        // Update text box, the quantity is automatically reset to 1.
        int quantity = 1;
        try
        {
            quantity = Integer.parseInt(quantityString);
            if (quantity < 0)
                quantity = 1;
        }
        catch(NumberFormatException nfe)
        {
            quantity = 1;
        }

        // If the user clicks the Remove button
        if (removeButtonValue != null)
        {
            quantity = 0;
        }

        // Get product from product code
        Product product = ProductDB.selectProduct(productCode);
        session.setAttribute("product", product);

        // If product exists, add or remove from cart
        if (product != null)
        {
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            if (quantity > 0)
                cart.addItem(lineItem);
            else
                cart.removeItem(lineItem);
        }
        session.setAttribute("cart", cart);
        
        // If no items exist in cart, forward to the Quick Order page.
        // Otherwise, forward to the Cart page.
        String url = "";
        if (cart.getItems().size() <= 0)
        {
            url = "/cart/displayQuickOrder";
        }
        else
        {
            url = "/cart/cart.jsp";
        }

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        doPost(request, response);
    }
}