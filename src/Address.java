public class Address
{
    private String street;
    private String city;
    private String state;
    private String zip;


    public Address(String aStreet, String aCity, String aState, String aZip)
    {
        street = aStreet;
        city = aCity;
        state = aState;
        zip = aZip;
    }


    public String format()
    {
        return String.format("%n%s%n%s, %s %s", street, city, state, zip);
    }
}
