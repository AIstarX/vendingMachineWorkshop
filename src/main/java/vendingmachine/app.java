package vendingmachine;

import model.product;

public class app {
    public static void main(String[] args) {
        vendingmachine vm = new candyvendingmachine();

        vm.addCurrency(50);
        System.out.println("Balance: " + vm.getBalance());

        for (String product : vm.getProducts()) {
            System.out.println(product);
        }

        product purchasedProduct = vm.request(1);
        System.out.println("Purchased: " + purchasedProduct.getDescription());

        int change = vm.endSession();
        System.out.println("Change returned: " + change);
    }
}
