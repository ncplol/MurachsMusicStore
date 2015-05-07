package music.data;

import java.sql.*;

import music.business.*;

public class DownloadDB
{
    public static int insert(Download download)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        int userID = UserDB.selectUserID(download.getUser());

        String query = "INSERT INTO Download "
                + "(UserID, DownloadDate, ProductCode) "
                + "VALUES "
                + "(?, NOW(), ?)";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setString(2, download.getProductCode());
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