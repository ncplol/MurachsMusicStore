package music.cart;

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
        String url = "/cart/user.jsp";

        // if the User object exists with address1, skip User page
        if (user != null && !user.getAddress1().equals("") )
        {
            url = "/cart/displayInvoice";
        }
        // otherwise, check the email cookie
        else
        {
            Cookie[] cookies = request.getCookies();
            String emailAddress =
                    CookieUtil.getCookieValue(cookies, "emailCookie");
            if (emailAddress.equals(""))
            {
                user = new User();
            }        
            else
            {
                user = UserDB.selectUser(emailAddress);
                if (user != null && !user.getAddress1().equals("")  )
                    url = "/cart/displayInvoice";
            }
        }
        session.setAttribute("user", user);

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