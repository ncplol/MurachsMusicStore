package music.data;

import java.sql.*;
import java.util.*;

import music.business.*;

public class ProductDB
{
    //This method returns null if a product isn't found.
    public static Product selectProduct(String productCode)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            if (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            }
            else
            {
                return null;
            }
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
    
    //This method will return 0 if productID isn't found.
    public static int selectProductID(Product product)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT ProductID FROM Product " +
                "WHERE ProductCode = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            rs = ps.executeQuery();
            rs.next();
            int productID = rs.getInt("ProductID");
            return productID;
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
    
    //This method returns null if a product isn't found.
    public static Product selectProduct(int productID)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Product " +
                "WHERE ProductID = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                return p;
            }
            else
            {
                return null;
            }
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
    
    //This method returns null if a product isn't found.
    public static ArrayList<Product> selectProducts()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Product";
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Product> products = new ArrayList<Product>();
            while (rs.next())
            {
                Product p = new Product();
                p.setCode(rs.getString("ProductCode"));
                p.setDescription(rs.getString("ProductDescription"));
                p.setPrice(rs.getDouble("ProductPrice"));
                products.add(p);
            }
            return products;
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
}