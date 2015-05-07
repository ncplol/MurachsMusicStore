package music.business;

import java.text.NumberFormat;
import java.io.Serializable;

public class LineItem implements Serializable
{
    private Product product;
    private int quantity;
    
    public LineItem() {}
    
    public void setProduct(Product p)
    {
        product = p;
    }

    public Product getProduct()
    { 
        return product;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = product.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}