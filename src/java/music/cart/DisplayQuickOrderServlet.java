package music.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;

import music.business.*;
import music.data.*;

public class DisplayQuickOrderServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response)
                      throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        // if list of products doesn't exist, initialize it, 
        // and store it for the remainder of the session
        if (session.getAttribute("products") == null)
        {
            ArrayList<Product> products = ProductDB.selectProducts();
            session.setAttribute("products", products);
        }
                
        // forward to the Quick Order page
        String url = "/cart/quick_order.jsp";
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);        
    }
    
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response)
                       throws ServletException, IOException
    {
        doGet(request, response);
    }
}