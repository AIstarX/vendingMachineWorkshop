package model;

public class Candy extends Product {
    private String flavor;

    public Candy(int id, String name, double price, String flavor) {
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