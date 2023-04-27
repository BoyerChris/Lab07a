public class LineItem {
    private int quantity;
    private Product theProduct;


    public LineItem(Product aProduct, int aQuantity) {
        theProduct = aProduct;
        quantity = aQuantity;
    }


    public double getTotalPrice() {
        return theProduct.getPrice() * quantity;
    }

    public String format() {
        return String.format("%-30s %14d %14.2f %14.2f",
                theProduct.getName(), quantity, theProduct.getPrice(), getTotalPrice());
    }
}
