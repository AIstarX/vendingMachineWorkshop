package vendingmachine;

import model.product;

public interface vendingmachine {
    void addCurrency(int amount);
    product request(int productId);
    int endSession();
    String getDescription(int productId);
    int getBalance();
    String[] getProducts();
}
