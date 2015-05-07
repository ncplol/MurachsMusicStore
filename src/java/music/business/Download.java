package music.business;

import java.util.Date;
import java.io.Serializable;

public class Download implements Serializable
{
    private User user;
    private Date downloadDate;
    private String productCode;

    public Download()
    {
        user = null;
        downloadDate = new Date();
        productCode = "";
    }

    public void setUser(User u)
    {
        user = u;
    }

    public User getUser()
    {
        return user;
    }

    public void setDownloadDate(Date date)
    {
        downloadDate = date;
    }

    public Date getDownloadDate()
    {
        return downloadDate;
    }

    public void setProductCode(String code)
    {
        productCode = code;
    }

    public String getProductCode()
    {
        return productCode;
    }
}