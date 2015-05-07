package music.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;

public class DisplayInvoiceServlet extends HttpServlet
{   
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {        
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");       
        Cart cart = (Cart) session.getAttribute("cart");

        java.util.Date today = new java.util.Date();

        Invoice invoice = new Invoice();
        invoice.setUser(user);
        invoice.setInvoiceDate(today);
        invoice.setLineItems(cart.getItems());
        
        session.setAttribute("invoice", invoice);
        
        String url = "/cart/invoice.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);
    }
}