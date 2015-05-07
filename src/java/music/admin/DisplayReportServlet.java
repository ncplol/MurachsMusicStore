package music.admin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import music.data.*;

public class DisplayReportServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {        
        response.setContentType("application/vnd.ms-excel");
        PrintWriter out = response.getWriter();
        
        String reportName = request.getParameter("reportName");
        String reportTitle = request.getParameter("reportTitle");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        String reportString = null;
        if (reportName.equalsIgnoreCase("userEmail"))
        {
            reportString = ReportDB.getUserEmail(reportTitle);
        }
        else if (reportName.equalsIgnoreCase("downloadDetail"))
        {
            reportString = ReportDB.getDownloadDetail(
                    reportTitle, startDate, endDate);
        }
        else if (reportName.equalsIgnoreCase("invoiceSummary"))
        {
            reportString = ReportDB.getOrderSummary(
                    reportTitle, startDate, endDate);
        }
        else if (reportName.equalsIgnoreCase("invoiceDetail"))
        {
            reportString = ReportDB.getOrderDetail(
                    reportTitle, startDate, endDate);
        }
        else
        {
            reportString = "The reportName was not found.";
        }
        out.println(reportString);
    }
    
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        doGet(request, response);
    }
}