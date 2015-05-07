package music.catalog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;
import music.util.*;

public class CheckUserServlet extends HttpServlet
{    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {               
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String url = "";

        // if the User object doesn't exist, check for the email cookie
        if (user == null)
        {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    CookieUtil.getCookieValue(cookies, "emailCookie");
            
            // if the email cookie doesn't exist, go to the registration page
            if (emailAddress == null || emailAddress.equals(""))
            {
                url = "/catalog/register.jsp";
            }
            
            // if the email cookie does exist, create the User object
            // from the email cookie and skip the registration page
            else
            {
                user = UserDB.selectUser(emailAddress);
                session.setAttribute("user", user);
                url = "/catalog/writeDownload";
            }
        }
        
        // if the User object exists, skip the registration page
        else
        {
            url = "/catalog/writeDownload";
        }

        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}