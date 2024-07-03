package modelOption2;

public class Candy implements Product {
    private int id;
    private String name;
    private double price;
    private String flavor;

    public Candy(int id, String name, double price, String flavor) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.flavor = flavor;
    }

    @Override
    public String examine() {
        return getDescription();
    }

    @Override
    public String use() {
        return "Eating " + name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public void setProductName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getDescription() {
        return name + " - " + flavor + " flavor, $" + price;
    }
}
