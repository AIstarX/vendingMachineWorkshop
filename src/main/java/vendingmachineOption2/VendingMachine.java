package vendingmachineOption2;

import modelOption2.Product;

public interface VendingMachine {
    void addCurrency(int amount);
    Product request(int productId);
    int endSession();
    String getDescription(int productId);
    int getBalance();
    String[] getProducts();
}
