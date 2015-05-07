package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.ArrayList;

import music.data.*;
import music.business.*;

public class DisplayInvoicesServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        ArrayList<Invoice> unprocessedInvoices = 
            InvoiceDB.selectUnprocessedInvoices();

        if (unprocessedInvoices == null ||
            unprocessedInvoices.size() <= 0)
        {
            response.sendRedirect("/musicStore/admin");
        }
        else
        {
            session.setAttribute("unprocessedInvoices", unprocessedInvoices);

            String url = "/admin/invoices.jsp";
            RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);
    }
}