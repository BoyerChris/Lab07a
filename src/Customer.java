import java.io.StringReader;

public class Customer
{
    private String customerName;
    private Address customerAddress;


    public Customer(String aName, Address aAddress)
    {
        customerName = aName;
        customerAddress = aAddress;
    }


    public String format()
    {
        return String.format("%n%s%s", customerName, customerAddress.format());

    }

    public Address getCustomerAddress()
    {
        return customerAddress;
    }
}
