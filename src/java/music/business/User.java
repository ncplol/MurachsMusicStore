package music.business;

import java.io.Serializable;

public class User implements Serializable
{
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String companyName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String creditCardType;
    private String creditCardNumber;
    private String creditCardExpirationDate;
    
    public User()
    {
        firstName = "";
        lastName = "";
        emailAddress = "";
        companyName = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip = "";
        country = "";
        creditCardType = "";
        creditCardNumber = "";
        creditCardExpirationDate = "";
    }
    
    public void setFirstName(String f)
    {
        firstName = f;
    }

    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName(String l)
    {
        lastName = l;
    }

    public String getLastName()
    {
        return lastName;
    }
    
    public void setEmailAddress(String e)
    {
        emailAddress = e;
    }
    
    public String getEmailAddress()
    {
        return emailAddress;
    }
    
    public void setCompanyName(String c)
    {
        companyName = c;
    }
    
    public String getCompanyName()
    {
        return companyName;
    }
    
    public void setAddress1(String a)
    {
        address1 = a;
    }

    public String getAddress1()
    {
        return address1;
    }
    
    public void setAddress2(String a)
    {
        address2 = a;
    }
    
    public String getAddress2()
    {
        return address2;
    }
    
    public void setCity(String c)
    {
        city = c;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setState(String s)
    {
        state = s;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setZip(String z)
    {
        zip = z;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public void setCountry(String c)
    {
        country = c;
    }
    
    public String getCountry()
    {
        return country;
    }

    // this works, but it mixes the Model and the View
    public String getAddressHTMLFormat()
    {
        String address = firstName + " " + lastName + "<br>";

        if (companyName == null || companyName.equals("") || companyName.equals(" "))
            address += "";
        else
            address += companyName + "<br>";
            address += address1 + "<br>";

        if (address2 == null || address2.equals("") || address2.equals(" "))
            address += "";
        else
            address += address2 + "<br>";
            
        address += city + ", " + state + " " + zip + "<br>" 
                + country;

        return address;
    }
    
    public void setCreditCardType(String c)
    {
        creditCardType = c;
    }
    
    public String getCreditCardType()
    {
        return creditCardType;
    }
    
    public void setCreditCardNumber(String n)
    {
        creditCardNumber = n;
    }
    
    public String getCreditCardNumber()
    {
        return creditCardNumber;
    }
    
    public void setCreditCardExpirationDate(String s)
    {
        creditCardExpirationDate = s;
    }
    
    public String getCreditCardExpirationDate()
    {
        return creditCardExpirationDate;
    }
}
