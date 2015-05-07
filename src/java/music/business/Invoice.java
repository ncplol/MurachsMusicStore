package music.business;

import java.util.*;
import java.text.*;
import java.io.Serializable;

public class Invoice implements Serializable
{
    private User user;
    private ArrayList<LineItem> lineItems;
    private Date invoiceDate;
    private int invoiceNumber;
    
    public Invoice()
    {}
    
    public void setUser(User user)
    {
        this.user = user;
    }
    
    public User getUser()
    { 
        return user; 
    }
    
    public void setLineItems(ArrayList<LineItem> items)
    {
        lineItems = items;
    }
    
    public ArrayList<LineItem> getLineItems()
    { 
        return lineItems; 
    }
    
    public void setInvoiceDate(Date date)
    {
        invoiceDate = date;
    }
    
    public Date getInvoiceDate()
    { 
        return invoiceDate; 
    }
    
    public String getInvoiceDateDefaultFormat()
    {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String invoiceDateFormatted = dateFormat.format(invoiceDate);
        return invoiceDateFormatted;
    }

    public void setInvoiceNumber(int number)
    {
        invoiceNumber = number;
    }

    public int getInvoiceNumber()
    { 
        return invoiceNumber; 
    }
    
    public double getInvoiceTotal()
    {
        double invoiceTotal = 0.0;
        for (int i=0; i<lineItems.size(); i++)
        {
            LineItem item = lineItems.get(i);
            invoiceTotal += item.getTotal();
        }
        return invoiceTotal;
    }
    
    public String getInvoiceTotalCurrencyFormat()
    {
        double total = this.getInvoiceTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(total);
        return formattedTotal;
    }
    
}