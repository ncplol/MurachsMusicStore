package music.data;

import java.sql.*;

public class ReportDB
{    
    // The User Email report
    public static String getUserEmail(String reportTitle)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        String query =
                "SELECT * "
                +  "FROM User "
                +  "ORDER BY LastName";
        try
        {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            String d = "\t";
            StringBuilder report = new StringBuilder(reportTitle + "\n\n"
                    + "LastName" + d
                    + "FirstName" + d
                    + "EmailAddress" + d
                    + "CompanyName" + d
                    + "Address1" + d
                    + "Address2" + d
                    + "City" + d
                    + "State" + d
                    + "Zip" + d
                    + "Country" + d
                    + "UserID" + "\n");
            while (rs.next())
            {
                report.append(rs.getString("LastName")+ d
                        + rs.getString("FirstName") + d
                        + rs.getString("EmailAddress") + d
                        + rs.getString("CompanyName") + d
                        + rs.getString("Address1") + d
                        + rs.getString("Address2") + d
                        + rs.getString("City") + d
                        + rs.getString("State") + d
                        + rs.getString("Zip") + d
                        + rs.getString("Country") + d
                        + rs.getInt("UserID") + "\n");
            }
            return report.toString();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
    
    // The Download Detail report
    public static String getDownloadDetail(String reportTitle, 
        String startDate, String endDate)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        String query =
                "SELECT DownloadDate, "
                +  "   Download.ProductCode, "
                +  "   EmailAddress, FirstName, LastName "
                +  "FROM User "
                +  "   INNER JOIN Download ON User.UserID = Download.UserID "
                +  "WHERE DownloadDate >= '" + startDate + "' "
                +  "   AND DownloadDate <= '" + endDate + "' "
                +  "ORDER BY DownloadDate DESC";
        try
        {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            String d = "\t";
            StringBuilder report = new StringBuilder(
                    reportTitle + "\n\n"
                    + "Start Date: " + startDate + "\n"
                    + "End Date: " + endDate + "\n\n"
                    + "DownloadDate" + d
                    + "ProductCode" + d
                    + "EmailAddress" + d
                    + "FirstName" + d
                    + "LastName" + "\n");
            int total = 0;
            while (rs.next())
            {
                report.append(
                        rs.getDate("DownloadDate").toString() + d
                        + rs.getString("ProductCode") + d
                        + rs.getString("EmailAddress") + d
                        + rs.getString("FirstName") + d
                        + rs.getString("LastName") + "\n");
                total += 1;
            }
            report.append("\nTotal Number of Downloads: " + total);
            return report.toString();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
    
    // The Order Summary report
    public static String getOrderSummary(String reportTitle, 
        String startDate, String endDate)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        String query =
                "SELECT ProductCode, ProductDescription, "
                +  "   ProductPrice, Quantity, "
                +  "   SUM(Quantity) AS ProductQuantity, "
                +  "   SUM(ProductPrice*Quantity) AS ProductTotal "
                +  "FROM Invoice "
                +  "   INNER JOIN LineItem ON Invoice.InvoiceID = LineItem.InvoiceID "
                +  "   INNER JOIN Product ON LineItem.ProductID = Product.ProductID "
                +  "WHERE InvoiceDate >= '" + startDate + "' "
                +  "   AND InvoiceDate <= '" + endDate + "' "
                +  "GROUP BY ProductCode, ProductDescription "
                +  "ORDER BY ProductTotal DESC";
        try
        {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            String d = "\t";
            StringBuilder report = new StringBuilder(
                    reportTitle + "\n\n"
                    + "Start Date: " + startDate + "\n"
                    + "End Date: " + endDate + "\n\n"
                    + "ProductCode" + d
                    + "ProductDescription" + d
                    + "ProductPrice" + d
                    + "Quantity" + d
                    + "Total" + "\n");
            while (rs.next())
            {
                report.append(rs.getString("ProductCode") + d
                        + rs.getString("ProductDescription") + d
                        + rs.getDouble("ProductPrice") + d
                        + rs.getInt("ProductQuantity") + d
                        + rs.getDouble("ProductTotal") + "\n");
            }
            return report.toString();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
    
    // The Order Detail report
    public static String getOrderDetail(String reportTitle, 
            String startDate, String endDate)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;

        String query =
                "SELECT InvoiceDate, Invoice.InvoiceID, "
                +    "User.UserID, EmailAddress, "
                +    "Product.ProductCode, ProductPrice, "
                +    "Quantity "
                +  "FROM User "
                +  "   INNER JOIN Invoice ON User.UserID = Invoice.UserID "
                +  "   INNER JOIN LineItem ON Invoice.InvoiceID = LineItem.InvoiceID "
                +  "   INNER JOIN Product ON LineItem.ProductID = Product.ProductID "
                +  "WHERE InvoiceDate >= '" + startDate + "' "
                +  "   AND InvoiceDate <= '" + endDate + "' "
                +  "ORDER BY InvoiceDate DESC";
        try
        {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            String d = "\t";
            StringBuilder report = new StringBuilder(
                    reportTitle + "\n\n"
                    + "Start Date: " + startDate + "\n"
                    + "End Date: " + endDate + "\n\n"
                    + "Date" + d
                    + "Time" + d
                    + "InvoiceID" + d
                    + "EmailAddress" + d
                    + "UserID" + d
                    + "ProductCode" + d
                    + "ProductPrice" + d
                    + "Quantity" + d
                    + "LineItemAmount" + "\n\n");
            double quantityTotal = 0;
            double dollarTotal = 0;
            while (rs.next())
            {
                Date invoiceDate = rs.getDate("InvoiceDate");
                String invoiceDateString = invoiceDate.toString();
                Time invoiceTime = rs.getTime("InvoiceDate");
                String invoiceTimeString = invoiceTime.toString();
                double price = rs.getDouble("ProductPrice");
                int quantity = rs.getInt("Quantity");
                double lineItemAmount = 0.0;
                lineItemAmount = price * quantity;
                report.append(invoiceDateString + d
                        + invoiceTimeString + d
                        + rs.getInt("InvoiceID") + d
                        + rs.getString("EmailAddress") + d
                        + rs.getInt("UserID") + d
                        + rs.getString("ProductCode") + d
                        + price + d
                        + quantity + d
                        + lineItemAmount + "\n");
                quantityTotal += quantity;
                dollarTotal += lineItemAmount;
            }
            report.append("\n");
            report.append("Totals:" + d + d + d + d + d + d + d
                    + quantityTotal + d + dollarTotal);
            return report.toString();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
}