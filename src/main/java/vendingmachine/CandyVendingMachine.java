package vendingmachine;

import model.Candy;
import model.Product;

public class CandyVendingMachine implements VendingMachine {
    private static final int[] VALID_AMOUNTS = {1, 2, 5, 10, 20, 50, 100};

    private Product[] products;
    private int depositPool;

    public CandyVendingMachine() {
        depositPool = 0;
        products = new Product[] {
                new Candy(1, "Chocolate Bar", 1.5, "Chocolate"),
                new Candy(2, "Gummy Bears", 1.0, "Gummy"),
                new Candy(3, "Lollipop", 0.5, "Cherry")
        };
    }

    @Override
    public void addCurrency(int amount) {
        if (isValidAmount(amount)) {
            depositPool += amount;
        } else {
            throw new IllegalArgumentException("Invalid currency amount");
        }
    }

    private boolean isValidAmount(int amount) {
        for (int validAmount : VALID_AMOUNTS) {
            if (validAmount == amount) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Product request(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                if (depositPool >= product.getPrice()) {
                    depositPool -= product.getPrice();
                    return product;
                } else {
                    throw new IllegalStateException("Insufficient funds");
                }
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public int endSession() {
        int moneyToReturn = depositPool;
        depositPool = 0;
        return moneyToReturn;
    }

    @Override
    public String getDescription(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product.getDescription();
            }
        }
        return "Product not found";
    }

    @Override
    public int getBalance() {
        return depositPool;
    }

    @Override
    public String[] getProducts() {
        String[] productDescriptions = new String[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            productDescriptions[i] = product.getId() + ", " + product.getName() + ", $" + product.getPrice();
        }
        return productDescriptions;
    }
}
