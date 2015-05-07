package music.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.business.*;
import music.data.*;

public class AddToEmailListServlet extends HttpServlet
{    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String emailAddress = request.getParameter("emailAddress");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmailAddress(emailAddress);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        
        String message = "";
        String url = null;
        //check that email address doesn't already exist
        if (UserDB.emailExists(emailAddress))
        {
            message = "This email address already exists. <br>"
                    + "Please enter another email address.";
            session.setAttribute("message", message);
            url = "/email/join_email_list.jsp";
        }
        else
        {
            UserDB.insert(user);
            message = "";
            session.setAttribute("message", message);
            url = "/email/show_email_entry.jsp";
        }

        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }   
}