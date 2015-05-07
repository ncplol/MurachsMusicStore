package music.catalog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;

public class WriteDownloadServlet extends HttpServlet
{    
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response)
                       throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        Product product = (Product) session.getAttribute("product");
        Download download = new Download();
        download.setUser(user);
        download.setProductCode(product.getCode());
        
        DownloadDB.insert(download);
        
        String url = "/catalog/" + product.getCode() + "/sound.jsp";
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