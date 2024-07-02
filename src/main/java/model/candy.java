package model;

public class candy extends product {
    private String flavor;

    public candy(int id, String name, double price, String flavor) {
        super(id, name, price);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String getDescription() {
        return getName() + " - " + flavor + " flavor, $" + getPrice();
    }
}
