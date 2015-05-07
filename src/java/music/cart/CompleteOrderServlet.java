package music.cart;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.*;
import javax.mail.*;

import music.business.*;
import music.data.*;
import music.util.*;

public class CompleteOrderServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Invoice invoice = (Invoice) session.getAttribute("invoice");

        String creditCardType
                = request.getParameter("creditCardType");
        String creditCardNumber
                = request.getParameter("creditCardNumber");
        String creditCardExpMonth
                = request.getParameter("creditCardExpirationMonth");
        String creditCardExpYear
                = request.getParameter("creditCardExpirationYear");

        user.setCreditCardType(creditCardType);
        user.setCreditCardNumber(creditCardNumber);
        user.setCreditCardExpirationDate(creditCardExpMonth
                + "/" + creditCardExpYear);

        // If a record for the User object exists, update it
        if (UserDB.emailExists(user.getEmailAddress())) {
            UserDB.update(user);
        } // Otherwise, write a new record for the User object
        else {
            UserDB.insert(user);
        }

        // Write a new invoice record
        InvoiceDB.insert(invoice);

        // Set the emailCookie in the user's browser.
        Cookie emailCookie = new Cookie("emailCookie",
                user.getEmailAddress());
        emailCookie.setMaxAge(60 * 24 * 365 * 2 * 60);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);

        // Remove all items from the user's cart
        Cart cart = (Cart) session.getAttribute("cart");
        cart.setItems(new ArrayList<LineItem>());

        // Send an email to the user to confirm the order.
        String to = user.getEmailAddress();
        String from = "confirmation@freshcornrecords.com";
        String subject = "Order Confirmation";
        String body = "Dear " + user.getFirstName() + ",\n\n"
                + "Thanks for ordering from us. "
                + "You should receive your order in 3-5 business days. "
                + "Please contact us if you have any questions.\n"
                + "Have a great day and thanks again!\n\n"
                + "Joe King\n"
                + "Fresh Corn Records";
        boolean isBodyHTML = false;
        try {
            MailUtil.sendMail(to, from, subject, body, isBodyHTML);
        } catch (MessagingException e) {
            this.log(
                    "Unable to send email. \n"
                    + "You may need to configure your system as "
                    + "described in chapter 15. \n"
                    + "Here is the email you tried to send: \n"
                    + "=====================================\n"
                    + "TO: " + to + "\n"
                    + "FROM: " + from + "\n"
                    + "SUBJECT: " + subject + "\n"
                    + "\n"
                    + body + "\n\n");
        }

        String url = "/cart/complete.jsp";
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
