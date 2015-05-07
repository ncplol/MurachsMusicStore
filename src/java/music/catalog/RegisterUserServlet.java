package music.catalog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;

public class RegisterUserServlet extends HttpServlet
{
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");
        
        User user = new User();        
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        
        if (UserDB.emailExists(emailAddress))
            UserDB.update(user);
        else
            UserDB.insert(user);

        session.setAttribute("user", user);
        
        Cookie emailCookie = new Cookie("emailCookie", emailAddress);
        emailCookie.setMaxAge(60*60*24*365*2);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);
        
        String url = "/catalog/writeDownload";
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}