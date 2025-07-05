package Task.Services;

public class TotalRecipe {
    private double subTotal;
    private double total;
    private double shipping;

    public TotalRecipe(double subTotal, double total, double shipping) {
        this.subTotal = subTotal;
        this.total = total;
        this.shipping = shipping;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }


    public void printTotalRecipe() {
        System.out.println("----------------------");
        System.out.println("Subtotal: " + subTotal);
        System.out.println("Shipping: " + shipping);
        System.out.println("Amount: " + total);
        System.out.println();
    }
}
