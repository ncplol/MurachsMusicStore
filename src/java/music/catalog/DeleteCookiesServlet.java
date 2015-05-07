package music.catalog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteCookiesServlet extends HttpServlet
{    
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response)
                      throws ServletException, IOException
    {
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++)
        {
            Cookie cookie = cookies[i];
            cookie.setMaxAge(0); //delete the cookie
            cookie.setPath("/"); //allow the entire application to access it
            response.addCookie(cookie);
        }

        String url = "/delete_cookies.jsp";
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
