package music.data;

import java.sql.*;
import java.util.*;

import music.business.*;

public class InvoiceDB
{
    public static int insert(Invoice invoice)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method adds a record to the Invoices table.
        //To insert the exact invoice date, the SQL NOW() function is used.
        int userID = UserDB.selectUserID(invoice.getUser());
        String query = "INSERT INTO Invoice (UserID, InvoiceDate, TotalAmount, IsProcessed) "
                + "VALUES (?, NOW(), ?, 'n')";

        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setDouble(2,invoice.getInvoiceTotal());
            ps.executeUpdate();

            //Get the InvoiceID from the last INSERT statement.
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            int invoiceID = identityResultSet.getInt("IDENTITY");
            identityResultSet.close();
            identityStatement.close();

            //Write line items to the LineItem table.
            ArrayList<LineItem> lineItems = invoice.getLineItems();
            for (int i = 0; i<lineItems.size(); i++)
            {
                LineItem item = lineItems.get(i);
                LineItemDB.insert(invoiceID, item);
            }            

            return 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static ArrayList<Invoice> selectUnprocessedInvoices()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method reads in all invoices that have not been
        //processed yet. To do this, it creates a ArrayList<Invoice> of
        //Invoice objects, which each contain a User object.
        //This method returns null if no unprocessed invoices are found.
        String query = "SELECT * " +
                "FROM User " +
                "INNER JOIN Invoice " +
                "ON User.UserID = Invoice.UserID " +
                "WHERE Invoice.IsProcessed = 'n' " +
                "ORDER BY InvoiceDate";
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Invoice> unprocessedInvoices = new ArrayList<Invoice>();
            while (rs.next())
            {
                //Create a User object
                User user = new User();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmailAddress(rs.getString("EmailAddress"));
                user.setCompanyName(rs.getString("CompanyName"));
                user.setAddress1(rs.getString("Address1"));
                user.setAddress2(rs.getString("Address2"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setZip(rs.getString("Zip"));
                user.setCountry(rs.getString("Country"));
                user.setCreditCardType(rs.getString("CreditCardType"));
                user.setCreditCardNumber(rs.getString("CreditCardNumber"));
                user.setCreditCardExpirationDate(rs.getString("CreditCardExpirationDate"));

                // get line items
                int invoiceID = rs.getInt("Invoice.InvoiceID");
                ArrayList<LineItem> lineItems = LineItemDB.selectLineItems(invoiceID);

                //Create the Invoice object
                Invoice invoice = new Invoice();
                invoice.setUser(user);
                invoice.setInvoiceDate(rs.getDate("InvoiceDate"));
                invoice.setInvoiceNumber(invoiceID);
                invoice.setLineItems(lineItems);

                unprocessedInvoices.add(invoice);
            }
            return unprocessedInvoices;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }

    }

    // This method sets the IsProcessed column to 'y'
    public static int updateInvoiceIsProcessed(int invoiceNumber)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        //This method is used by the admin application to set the Invoices.IsProcessed field to "y".
        String query = "UPDATE Invoice SET " +
                "IsProcessed = 'y' " +
                "WHERE InvoiceID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, invoiceNumber);
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}