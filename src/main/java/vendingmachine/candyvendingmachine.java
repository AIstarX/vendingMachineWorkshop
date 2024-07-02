package vendingmachine;

import model.candy;
import model.product;

import java.util.ArrayList;
import java.util.List;

public class candyvendingmachine implements vendingmachine {
    private List<product> products;
    private int depositPool;

    public candyvendingmachine() {
        products = new ArrayList<>();
        depositPool = 0;

        products.add(new candy(1, "Chocolate Bar", 1.5, "Chocolate"));
        products.add(new candy(2, "Gummy Bears", 1.0, "Gummy"));
        products.add(new candy(3, "Lollipop", 0.5, "Cherry"));
    }

    @Override
    public void addCurrency(int amount) {
        if (amount == 1 || amount == 2 || amount == 5 || amount == 10 ||
                amount == 20 || amount == 50 || amount == 100 || amount == 200 ||
                amount == 500 || amount == 1000) {
            depositPool += amount;
        } else {
            throw new IllegalArgumentException("Invalid currency amount");
        }
    }

    @Override
    public product request(int productId) {
        for (product product : products) {
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
        for (product product : products) {
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
        String[] productDescriptions = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            product product = products.get(i);
            productDescriptions[i] = product.getId() + ", " + product.getName() + ", $" + product.getPrice();
        }
        return productDescriptions;
    }
}
