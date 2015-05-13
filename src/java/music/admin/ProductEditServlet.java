/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import music.Product;
import music.ProductIO;

/**
 *
 * @author drshwin92
 */
@WebServlet(name = "ProductEditServlet", urlPatterns = {"/ProductEditServlet"})
public class ProductEditServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get parameters from the request 
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String stringPrice = request.getParameter("price");
        double price = Double.parseDouble(stringPrice);
        System.out.println("code is this: " + code);
        System.out.println("Decription is this: " + description);
        System.out.println("Price is this: " + stringPrice);

        String path = "C:\\Users\\Nick\\Documents\\NetBeansProjects\\music\\MurachsMusicStore\\web\\WEB-INF\\products.txt";

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);

        ProductIO.update(product, path);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(
                "<!doctype html public \"-//W3C//DTD HTML 4.0 "
                + " Transitional//EN\" >\n"
                + "<html>\n"
                + "<head>\n"
                + " <title>Murach's Java Servlets and JSP</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Product updated successfully!</h1>\n"
                + "<p>Here is the information that you entered:</p>\n"
                + " <table cellspacing=\"5\" cellpadding=\"5\" border=\"1\">\n"
                + " <tr><td align=\"right\">Product Code:</td>\n"
                + "     <td>" + code + "</td>\n"
                + " </tr>\n"
                + " <tr><td align=\"right\">Description:</td>\n"
                + "     <td>" + description + "</td>\n"
                + " </tr>\n"
                + " <tr><td align=\"right\">Price:</td>\n"
                + "     <td>" + price + "</td>\n"
                + " </tr>\n"
                + " </table>\n"
                + "<p>To update another product, click the back button in your browser.</p>\n"
                + "<form action=\"product_maintenance.jsp\" method=\"post\">\n"
                + " <input type=\"submit\" value=\"Return\">\n"
                + "</form>\n"
                + "</body>\n"
                + "</html>\n"
        );

        out.close();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductEditServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductEditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
